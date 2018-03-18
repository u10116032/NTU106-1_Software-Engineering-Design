import java.util.*;

public class CustomServiceStaff extends Staff {
	
	private CustomService customService;

	public CustomServiceStaff(CustomService customService)
	{
		this.customService = customService;
	}

	public void addOrder(int date, int hour, int performanceDate, String name, String phone, int numAttendees, Map<Integer, DailyPerformance> dailyPerformanceMap, Map<Integer, Order> orderMap)
	{
		customService.addOrder(date, hour, performanceDate, name, phone, numAttendees, dailyPerformanceMap, orderMap);
	}

	public void cancel(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap)
	{
		customService.cancel(date, hour, reservationNumber, name, phone, orderMap);
	}

}