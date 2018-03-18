import java.util.*;

public class PhoneBooking implements BookingService{

	public CustomService customService;

	public PhoneBooking(CustomService customService)
	{
		this.customService = customService;
	}

	public void bookTicket(int date, int hour, int performanceDate, String name, String phone, int numAttendees, Map<Integer, DailyPerformance> dailyPerformanceMap, Map<Integer, Order> orderMap)
	{
		DailyPerformance dailyPerformance = dailyPerformanceMap.get(performanceDate);
		if (dailyPerformance == null)
			System.out.println("Book fail. Not enough seats in requested performance.");

		if (dailyPerformance.getNumberSeats() < numAttendees){
			System.out.println("Book fail. Not enough seats in requested performance.");
			return;
		}

		dailyPerformance.decreaseNumberSeats(numAttendees);

		int reservationNumber = customService.getReservationNumber();
		Order order = new Order(reservationNumber, name, phone, performanceDate, numAttendees);
		orderMap.put(reservationNumber, order);
		System.out.println("Reserve #" + reservationNumber + ". name: " + name + ", tickets: " + numAttendees);

		reservationNumber = reservationNumber + 1;
	}

}