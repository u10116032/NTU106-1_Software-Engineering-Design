import java.util.*;

public class Patient {

	private String patientName;
	private int frequency;

	private List<Sensor> sensors;
	private Map<Sensor, SafeRange> safty;

	public Patient(String patientName, int frequency)
	{
		this.patientName = patientName;
		this.frequency = frequency;

		sensors = new ArrayList<>();
		safty = new HashMap<Sensor, SafeRange>();
	}

	public List<Sensor> getSensors()
	{
		return sensors;
	}

	public boolean getSafeRange(Sensor sensor, float factor)
	{
		SafeRange safeRange = safty.get(sensor);

		if (factor > safeRange.upperBound || factor < safeRange.lowerBound)
			return false;
		else
			return true;
	}

	public int getFrequency()
	{
		return frequency;
	}

	public void attachSensor(Sensor sensor, SafeRange safeRange)
	{
		sensors.add(sensor);
		safty.put(sensor, safeRange);
	}

	public String getPatientName()
	{
		return this.patientName;
	}
}