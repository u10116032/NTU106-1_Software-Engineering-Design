import java.util.*;
import java.io.*;

public abstract class Sensor {

	protected String sensorName;
	protected String sensorCategory;

	private List<Float> recordList;
	private List<Integer> timeList;

	public Sensor(String sensorName, String sensorCategory)
	{
		this.sensorName = sensorName;
		this.sensorCategory = sensorCategory;

		recordList = new ArrayList<>();
		timeList = new ArrayList<>();
	}

	public abstract float read();

	public void record(int time, float factor)
	{
		timeList.add(time);
		recordList.add(factor);
	}

	public void display()
	{
		for (int index = 0; index < timeList.size(); index++)
			System.out.println("[" + timeList.get(index) + "] " + String.format("%.1f", recordList.get(index)));
		
	}

	public String getSensorName()
	{
		return sensorName;
	}

	public String getSensorCategory()
	{
		return sensorCategory;
	}

	@Override
	public boolean equals(Object object){
		if(object instanceof Sensor){
			Sensor otherSensor = (Sensor)object;
			return this.sensorName == otherSensor.getSensorName();
		}
		else
			return false;
	}

	@Override
	public int hashCode()
	{
		return sensorName.hashCode();
	}

}