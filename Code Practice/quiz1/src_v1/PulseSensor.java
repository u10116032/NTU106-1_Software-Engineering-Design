import java.util.*;
import java.io.*;

public class PulseSensor extends Sensor{

	private BufferedReader reader;
	public PulseSensor(String sensorName, String filePath)
	{
		super(sensorName, "PulseSensor");

		File file = new File(filePath);
		try{
			reader = new BufferedReader(new FileReader(file));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	} 

	public float read() 
	{
		float factor = -1.0f;

		try{
			String element = reader.readLine();
			if (element!=null)
				factor = Float.parseFloat(element);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		if (factor == -1.0f)
			throw new IndexOutOfBoundsException();
		return factor;
	}
}