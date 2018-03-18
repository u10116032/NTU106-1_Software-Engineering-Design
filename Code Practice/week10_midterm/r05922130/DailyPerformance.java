import java.util.*;

public class DailyPerformance {

	private int date;
	private int hour;
	private int numberSeats;
	private List<Integer> seatNumberList; // description

	public DailyPerformance(int date, int hour, int numberSeats)
	{
		this.date = date;
		this.hour = hour;
		this.numberSeats = numberSeats;

		seatNumberList = new ArrayList<Integer>();
	}

	public int getDate()
	{
		return date;
	}

	public int getHour()
	{
		return hour;
	}

	public int getNumberSeats()
	{
		return numberSeats;
	}

	public void decreaseNumberSeats(int numberSeats)
	{
		this.numberSeats -= numberSeats;
	}
}