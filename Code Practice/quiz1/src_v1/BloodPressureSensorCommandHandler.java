import java.util.*;
import java.io.*;

public class BloodPressureSensorCommandHandler implements CommandHandler{
	
	private FactorMonitor monitor;
	
	public BloodPressureSensorCommandHandler(FactorMonitor monitor)
	{
		this.monitor = monitor;
	}

	public void execute(List<String> tokens)
	{		
		BloodPressureSensor sensor = new BloodPressureSensor(tokens.get(0), tokens.get(1));
		
		Patient patient = monitor.getLastPatient();
		patient.attachSensor(sensor, new SafeRange(Float.parseFloat(tokens.get(2)), Float.parseFloat(tokens.get(3))));
	}
}