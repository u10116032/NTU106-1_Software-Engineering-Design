import java.util.*;

public class BoxOfficeStaff extends Staff {
	
	private BoxOffice boxOffice;

	public BoxOfficeStaff(BoxOffice boxOffice)
	{
		this.boxOffice = boxOffice;
	}

	public void pickupTicket(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap)
	{
		boxOffice.pickupTicket(date, hour, reservationNumber, name, phone, orderMap);
	}
}