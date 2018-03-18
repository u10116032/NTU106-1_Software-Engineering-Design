import java.util.*;
import java.io.*;

public class TemperatureSensorCommandHandler implements CommandHandler{
	
	private FactorMonitor monitor;
	
	public TemperatureSensorCommandHandler(FactorMonitor monitor)
	{
		this.monitor = monitor;
	}

	public void execute(List<String> tokens)
	{

		TemperatureSensor sensor = new TemperatureSensor(tokens.get(0), tokens.get(1));
		
		Patient patient = monitor.getLastPatient();
		patient.attachSensor(sensor, new SafeRange(Float.parseFloat(tokens.get(2)), Float.parseFloat(tokens.get(3))));
	}
}