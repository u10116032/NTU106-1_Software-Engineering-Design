import java.util.*;

public class CustomService {
	
	private BookingService bookingService;
	private CancelService cancelService;

	private int reservationNumber;

	public CustomService()
	{
		bookingService = new PhoneBooking(this);
		cancelService = new PhoneCancel();

		reservationNumber = 1;
	}

	public void addOrder(int date, int hour, int performanceDate, String name, String phone, int numAttendees, Map<Integer, DailyPerformance> dailyPerformanceMap, Map<Integer, Order> orderMap)
	{
		bookingService.bookTicket(date, hour, performanceDate, name, phone, numAttendees, dailyPerformanceMap, orderMap);
	}

	public void cancel(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap)
	{
		cancelService.cancelTicket(date, hour, reservationNumber, name, phone, orderMap);
	}

	public int getReservationNumber()
	{
		return reservationNumber++;
	}

}