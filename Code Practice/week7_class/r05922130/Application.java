import java.util.*;
import java.io.*;

public class Application{

	private Map<String, CommandHandler> commandMap;
	private Store store;

	public Application(String inputFileName)
	{
		store = new Store();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("department", new DepartmentCommandHandler(store));
		commandMap.put("select", new SelectCommandHandler(store));

		try{
			File inputFile = new File(inputFileName);
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String command;
			while ((command = reader.readLine()) != null){
				List<String> tokens = CommandTokenizer.INSTANCE.parse(command);
				String commandType = tokens.get(0);
				tokens.remove(0);
				commandMap.get(commandType).execute(tokens);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}