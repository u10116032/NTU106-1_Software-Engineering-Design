import java.util.*;
import java.io.*;

public class MonitorSystem{

	private int period;

	private List<Patient> patientList;
	private Map<String, CommandHandler> commandMap;

	public MonitorSystem(String inputFileName)
	{
		patientList = new ArrayList<>();

		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("patient", new PatientCommandHandler(this));
		commandMap.put("PulseSensor", new FactorDatabaseCommandHandler(this, "PulseSensor"));
		commandMap.put("BloodPressureSensor", new FactorDatabaseCommandHandler(this, "BloodPressureSensor"));
		commandMap.put("TemperatureSensor", new FactorDatabaseCommandHandler(this, "TemperatureSensor"));

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

	public void start()
	{
		for (int time = 0; time <= period; ++time){
			for(Patient patient : patientList)
				patient.checkSensor(time);
		}

		for (Patient patient : patientList){
			MonitorLogger.INSTANCE.Log("patient " + patient.getName());
			for (FactorDatabase sensor : patient.getSensors()){
				MonitorLogger.INSTANCE.Log(sensor.getSensorCategory() + " " + sensor.getSensorName());

				int patientPeriod = patient.getPeriod();
				int count = period / patientPeriod;
				for(int i = 0; i <= count; ++i)
					MonitorLogger.INSTANCE.Log("[" + i * patientPeriod + "] " + String.format("%.1f", sensor.getRecord(i)));
				
			}
		}
	}

}