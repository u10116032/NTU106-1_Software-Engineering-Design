import java.util.*;

public class PickupCommandHandler implements CommandHandler {

	private Theater theater;

	public PickupCommandHandler(Theater theater)
	{
		this.theater = theater;
	}

	public void execute(List<String> tokens)
	{
		int date = Integer.parseInt(tokens.get(0).split(",")[0]); 
		int hour = Integer.parseInt(tokens.get(0).split(",")[1]); 
		int reservationNumber = Integer.parseInt(tokens.get(1));
		String name = tokens.get(2);
		String phone = tokens.get(3);

		theater.checkStatus(date, hour);
		theater.pickupTicket(date, hour, reservationNumber, name, phone);

	}

	
}