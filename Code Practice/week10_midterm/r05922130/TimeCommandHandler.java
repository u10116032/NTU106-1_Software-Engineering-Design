import java.util.*;

public class TimeCommandHandler implements CommandHandler {

	private Theater theater;

	public TimeCommandHandler(Theater theater)
	{
		this.theater = theater;
	}

	public void execute(List<String> tokens)
	{
		int date = Integer.parseInt(tokens.get(0).split(",")[0]); 
		int hour = Integer.parseInt(tokens.get(0).split(",")[1]); 

		theater.checkStatus(date, hour);
	}

	
}


