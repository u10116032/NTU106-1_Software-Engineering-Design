import java.util.*;
import java.io.*;

public class FactorMonitor{

	private int period;

	private List<Patient> patientList;
	private Map<String, CommandHandler> commandMap;

	public FactorMonitor(String inputFileName)
	{
		patientList = new ArrayList<>();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("patient", new PatientCommandHandler(this));
		commandMap.put("PulseSensor", new PulseSensorCommandHandler(this));
		commandMap.put("BloodPressureSensor", new BloodPressureSensorCommandHandler(this));
		commandMap.put("TemperatureSensor", new TemperatureSensorCommandHandler(this));

		try{
			File inputFile = new File(inputFileName);
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			this.period = Integer.parseInt(reader.readLine());

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

	public void addPatient(Patient patient)
	{
		patientList.add(patient);
	}

	public Patient getLastPatient()
	{
		return patientList.get(patientList.size() - 1);
	}

	private void displayAlarm(String message)
	{
		System.out.println(message);
	}

	private void saveToDatabase(Sensor sensor, int time, float factor)
	{
		sensor.record(time, factor);
	}

	public void monitor()
	{
		for (int time = 0; time <= period; ++time){
			for(Patient patient : patientList){
				if (time % patient.getFrequency() != 0)
					continue;

				for(Sensor sensor : patient.getSensors()){

					float factor = -1.0f;

					try {
						factor = sensor.read();

						if (!patient.getSafeRange(sensor, factor)){
							String message = "[" + time + "] " + 
								patient.getPatientName() + " is in danger! Cause: " + sensor.sensorName +
								" " + String.format("%.1f", factor);

							displayAlarm(message);					
						}
					}
					catch (IndexOutOfBoundsException e){
						String message = "[" + time + "] " + 
							sensor.sensorName + 
							" falls";
						displayAlarm(message);
					}

					saveToDatabase(sensor, time, factor);					
				}
				
			}
		}

		for (Patient patient : patientList){
			System.out.println("patient " + patient.getPatientName());
			for (Sensor sensor : patient.getSensors()){
				System.out.println(sensor.getSensorCategory() + " " + sensor.getSensorName());

				sensor.display();
				
			}
		}
	}

}