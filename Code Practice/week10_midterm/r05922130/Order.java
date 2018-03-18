import java.util.*;

public class Order {
	
	private int reservationNumber;
	private String customerName;
	private String phoneNumber;
	private int date;
	private List<Integer> seatNumber;
	private int numberOfTickets;

	private boolean isCanceled_;
	private boolean isPickedUp_;

	public Order(int reservationNumber, String customerName, String phoneNumber, int date, int numberOfTickets)
	{
		this.reservationNumber = reservationNumber;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.numberOfTickets = numberOfTickets;

		isCanceled_ = false;
		isPickedUp_ = false;

		seatNumber = new ArrayList<Integer>();
	}

	public int getReservationNumber()
	{
		return reservationNumber;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public int getDate()
	{
		return date;
	}

	public int getNumberOfTickets()
	{
		return numberOfTickets;
	}

	public boolean isCanceled()
	{
		return isCanceled_;
	}

	public boolean isPickedUp()
	{
		return isPickedUp_;
	}

	public void setCanceled(boolean isCanceled_)
	{
		this.isCanceled_ = isCanceled_;
	}

	public void setPickedUp(boolean isPickedUp_)
	{
		this.isPickedUp_ = isPickedUp_;
	}

}