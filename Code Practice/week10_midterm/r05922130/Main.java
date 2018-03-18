import java.util.*;
import java.io.*;

public class Main {

	private static Map<String, CommandHandler> commandMap;
	private static Theater theater;

	public static void main(String args[])
	{
		theater = new Theater();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("performance", new PerformanceCommandHandler(theater));
		commandMap.put("book", new BookCommandHandler(theater));
		commandMap.put("pickup", new PickupCommandHandler(theater));
		commandMap.put("cancel", new CancelCommandHandler(theater));
		commandMap.put("time", new TimeCommandHandler(theater));

		try{
			File inputFile = new File(args[0]);
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String command;
			while ((command = reader.readLine()) != null){
				List<String> tokens = CommandTokenizer.INSTANCE.parse(command);
				String commandType = tokens.get(0);
				tokens.remove(0);

				if (commandMap.containsKey(commandType))
					commandMap.get(commandType).execute(tokens);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
}