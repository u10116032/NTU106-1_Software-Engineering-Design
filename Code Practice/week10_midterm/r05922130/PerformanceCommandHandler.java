import java.util.*;

public class PerformanceCommandHandler implements CommandHandler {

	private Theater theater;

	public PerformanceCommandHandler (Theater theater)
	{
		this.theater = theater;
	}

	public void execute(List<String> tokens)
	{
		int date = Integer.parseInt(tokens.get(0));
		int hour = Integer.parseInt(tokens.get(1));
		int numberSeats = Integer.parseInt(tokens.get(2));

		theater.addPerformance(date, hour, numberSeats);
	}

}