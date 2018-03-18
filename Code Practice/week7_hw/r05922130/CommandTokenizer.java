import java.util.*;

public enum CommandTokenizer{
	INSTANCE;

	public List<String> parse(String command)
	{
		String[] tokens = command.split(" ");

		return new ArrayList<>(Arrays.asList(tokens));
	}
}