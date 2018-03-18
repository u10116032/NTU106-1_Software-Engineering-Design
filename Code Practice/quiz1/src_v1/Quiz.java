public class Quiz{

	public static void main(String[] args)
	{
		FactorMonitor monitor = null;
		try{
			monitor = new FactorMonitor(args[0]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		monitor.monitor();
	}
}