import java.util.*;
import java.io.*;

public class Main {

	private static WeatherSystem weatherSystem;

	public static void main(String[] args)
	{
		try {
			weatherSystem = new WeatherSystem();

			File file = new File(args[0]);
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String command;
			while ((command = reader.readLine()) != null){
				List<String> tokens = new ArrayList<>(Arrays.asList(command.split(" ")));

				String commandType = tokens.get(0);
				switch (commandType) {
					case "attach":{
						String area = tokens.get(1);
						String displayType = tokens.get(2);

						weatherSystem.attachDisplay(area, displayType);
						break;}
					case "detach": {
						String area = tokens.get(1);
						String displayType = tokens.get(2);

						weatherSystem.detachDisplay(area, displayType);
						break;}
					case "data": {
						String area = tokens.get(1);
						double temperature = Double.parseDouble(tokens.get(2));
						double humidity = Double.parseDouble(tokens.get(3));
						double pressure = Double.parseDouble(tokens.get(4));

						weatherSystem.addWeatherData(area, temperature, humidity, pressure);
						
						break;}
				}
			}
		}	
		catch(IOException e){
			e.printStackTrace();
		}
	}
}