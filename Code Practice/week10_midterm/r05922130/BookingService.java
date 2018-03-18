import java.util.*;

public interface BookingService {

	void bookTicket(int date, int hour, int performanceDate, String name, String phone, int numAttendees, Map<Integer, DailyPerformance> dailyPerformanceMap, Map<Integer, Order> orderMap);

}