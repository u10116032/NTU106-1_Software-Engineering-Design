import java.util.*;
import java.io.*;

public class Main {

	private static Map<String, CommandHandler> commandMap;
	private static Composition composition;
	public static void main(String args[])
	{
		composition = new Composition();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("Text", new TextCommandHandler(composition));
		commandMap.put("GraphicalElement", new GraphicalElementCommandHandler(composition));
		commandMap.put("ChangeSize", new ChangeSizeCommandHandler(composition));
		commandMap.put("Require", new RequireCommandHandler(composition));

		try{
			File inputFile = new File(args[0]);
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