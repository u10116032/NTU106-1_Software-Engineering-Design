import java.util.*;
import java.io.*;

public class Main {

	private static SpreadSheetApplication spreadSheetApplication;
	private static Map<String, CommandHandler> commandMap;

	public static void main(String args[])
	{
		spreadSheetApplication = new SpreadSheetApplication();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("data", new DataCommandHandler(spreadSheetApplication));
		commandMap.put("addChart", new AddChartCommandHandler(spreadSheetApplication));
		commandMap.put("change", new ChangeCommandHandler(spreadSheetApplication));
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String command;
			while((command = reader.readLine()) != null){
				List<String> tokens = new ArrayList<>(Arrays.asList(command.split(" ")));
				String commandType = tokens.get(0);
				tokens.remove(0);

				if (commandMap.containsKey(commandType))
					commandMap.get(commandType).execute(tokens);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}