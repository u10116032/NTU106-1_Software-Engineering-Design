import java.util.*;

public class FactorDatabaseCommandHandler implements CommandHandler{
	
	private MonitorSystem monitor;
	private String sensorType;
	
	public FactorDatabaseCommandHandler(MonitorSystem monitor, String sensorType)
	{
		this.monitor = monitor;
		this.sensorType = sensorType;
	}

	public void execute(List<String> tokens)
	{
		FactorDatabase sensor = new FactorDatabase(sensorType, tokens.get(0), tokens.get(1), Float.parseFloat(tokens.get(2)), Float.parseFloat(tokens.get(3)));
		Patient patient = monitor.getLastPatient();
		patient.addSensor(sensor);
	}
}