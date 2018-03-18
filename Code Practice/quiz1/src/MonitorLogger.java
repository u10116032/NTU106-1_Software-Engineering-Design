import java.io.*;

public enum MonitorLogger{
	INSTANCE;

	public void Log(String message)
	{
		System.out.println(message);
	}
}