import java.util.*;

public interface CancelService {

	void cancelTicket(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap);

}