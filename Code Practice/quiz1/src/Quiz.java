public class Quiz{

	public static void main(String[] args)
	{
		MonitorSystem monitor = null;
		try{
			monitor = new MonitorSystem(args[0]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		monitor.start();
	}
}