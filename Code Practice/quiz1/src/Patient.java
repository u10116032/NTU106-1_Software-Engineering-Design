import java.util.*;

public class Patient {

	private String name;
	private int period;

	private List<FactorDatabase> sensors;

	public Patient(String name, int period)
	{
		this.name = name;
		this.period = period;
		sensors = new ArrayList<>();
	}

	public void addSensor(FactorDatabase sensor)
	{
		sensors.add(sensor);
	}

	public void checkSensor(int timeStamp)
	{
		if(timeStamp % period != 0)
			return;
		int index = timeStamp / period;

		for (FactorDatabase sensor : sensors){
			int result = sensor.checkStatus(index);

			String message;
			switch(result){
				case FactorDatabase.DANGEROUS:
					message = "[" + timeStamp + "] " + 
						name + " is in danger! Cause: " + sensor.getSensorName() +
						" " + String.format("%.1f", sensor.getRecord(index));
					MonitorLogger.INSTANCE.Log(message);
					break;
				case FactorDatabase.FAIL:
					message = "[" + timeStamp + "] " + 
						sensor.getSensorName() + 
						" falls";
					MonitorLogger.INSTANCE.Log(message);
					break;
			}
		}
	}

	public String getName()
	{
		return this.name;
	}

	public List<FactorDatabase> getSensors()
	{
		return this.sensors;
	}

	public int getPeriod()
	{
		return this.period;
	}
}