import java.util.*;
import java.util.Map.*;

public class Theater {
	private Map<Integer, DailyPerformance> dailyPerformanceMap;
	private Map<Integer, Order> orderMap;

	private CustomServiceStaff customServiceStaff;
	private BoxOfficeStaff boxOfficeStaff;

	private CustomService customService;
	private BoxOffice boxOffice;

	public Theater()
	{
		dailyPerformanceMap = new HashMap<Integer, DailyPerformance>();
		orderMap = new HashMap<Integer, Order>();

		customService = new CustomService();
		boxOffice = new BoxOffice();

		customServiceStaff = new CustomServiceStaff(customService);
		boxOfficeStaff = new BoxOfficeStaff(boxOffice);
	}

	public void addPerformance(int date, int hour, int numberSeats)
	{
		DailyPerformance dailyPerformance = new DailyPerformance(date, hour, numberSeats);
		dailyPerformanceMap.put(date, dailyPerformance);
	}

	public void addOrder(int date, int hour, int performanceDate, String name, String phone, int numAttendees)
	{
		customServiceStaff.addOrder(date, hour, performanceDate, name, phone, numAttendees, dailyPerformanceMap, orderMap);
	}

	public void pickupTicket(int date, int hour, int reservationNumber, String name, String phone)
	{
		boxOfficeStaff.pickupTicket(date, hour, reservationNumber, name, phone, orderMap);
	}

	public void cancel(int date, int hour, int reservationNumber, String name, String phone)
	{
		customServiceStaff.cancel(date, hour, reservationNumber, name, phone, orderMap);
	}

	public Map<Integer, DailyPerformance> getDailyPerformanceMap()
	{
		return dailyPerformanceMap;
	}

	public Map<Integer, Order> getOrderMap()
	{
		return orderMap;
	}

	public void checkStatus(int currentDate, int currentHour)
	{
		for (DailyPerformance dailyPerformance : dailyPerformanceMap.values()){
			int dailyPerformanceDate = dailyPerformance.getDate();
			int dailyPerformanceHour = dailyPerformance.getHour();

			if (((dailyPerformanceDate * 24 + dailyPerformanceHour) - (currentDate * 24 + currentHour)) <= 2){
				for (Order order : orderMap.values()){
					if (!order.isPickedUp() && !order.isCanceled() && order.getDate() == dailyPerformanceDate){
						order.setCanceled(true);
						orderMap.put(order.getReservationNumber(), order);

						System.out.println("Cancel #" + order.getReservationNumber() + ". name: " + order.getCustomerName() + ", tickets: " + order.getNumberOfTickets());
					}
				}
			}

			if ((dailyPerformanceDate * 24 + dailyPerformanceHour) == (currentDate * 24 + currentHour)){
				
				Iterator<Entry<Integer, Order>> iterator = orderMap.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<Integer, Order> entry = iterator.next();
					if (!entry.getValue().isPickedUp() && entry.getValue().isCanceled() && entry.getValue().getDate() == dailyPerformanceDate) {
						iterator.remove();
						System.out.println("Clear #" + entry.getValue().getReservationNumber() + ". name: " + entry.getValue().getCustomerName() + ", tickets: " + entry.getValue().getNumberOfTickets());
					}
				}
			}

		}

	}
}

