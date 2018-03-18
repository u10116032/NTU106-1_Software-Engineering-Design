import java.util.*;

public class PatientCommandHandler implements CommandHandler{

	private FactorMonitor monitor;

	public PatientCommandHandler(FactorMonitor monitor)
	{
		this.monitor = monitor;
	}

	public void execute(List<String> tokens)
	{
		Patient patient = new Patient(tokens.get(0), Integer.parseInt(tokens.get(1)));
		monitor.addPatient(patient);
	}
}