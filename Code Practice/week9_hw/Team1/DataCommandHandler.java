import java.util.*;

public class DataCommandHandler implements CommandHandler {

	private SpreadSheetApplication spreadSheetApplication;

	public DataCommandHandler(SpreadSheetApplication spreadSheetApplication)
	{
		this.spreadSheetApplication = spreadSheetApplication;
	}

	public void execute(List<String> tokens)
	{
		String type = tokens.get(0);
		int value = Integer.parseInt(tokens.get(1));

		Data data = new Data(type, value);
		spreadSheetApplication.addData(type, data);
	}

}