import java.util.*;

public class BookCommandHandler implements CommandHandler {

	private Theater theater;

	public BookCommandHandler(Theater theater)
	{
		this.theater = theater;
	}

	public void execute(List<String> tokens)
	{
		int date = Integer.parseInt(tokens.get(0).split(",")[0]); 
		int hour = Integer.parseInt(tokens.get(0).split(",")[1]); 
		int performanceDate = Integer.parseInt(tokens.get(1));
		String name = tokens.get(2);
		String phone = tokens.get(3);
		int numAttendees = Integer.parseInt(tokens.get(4));

		theater.checkStatus(date, hour);
		theater.addOrder(date, hour, performanceDate, name, phone, numAttendees);
		
	}

	
}