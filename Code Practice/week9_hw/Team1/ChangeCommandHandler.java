import java.util.*;

public class ChangeCommandHandler implements CommandHandler {
	
	private SpreadSheetApplication spreadSheetApplication;

	public ChangeCommandHandler(SpreadSheetApplication spreadSheetApplication)
	{
		this.spreadSheetApplication = spreadSheetApplication;
	}

	public void execute(List<String> tokens)
	{
		String chartType = tokens.get(0);
		String item = tokens.get(1);
		int value = Integer.parseInt(tokens.get(2));
		
		System.out.println(chartType + " change " + item + " " + value + ".");

		spreadSheetApplication.change(chartType, item, value);
	}
}