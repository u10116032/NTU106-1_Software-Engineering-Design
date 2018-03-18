import java.util.*;

public class AddChartCommandHandler implements CommandHandler {

	private SpreadSheetApplication spreadSheetApplication;

	public AddChartCommandHandler(SpreadSheetApplication spreadSheetApplication)
	{
		this.spreadSheetApplication = spreadSheetApplication;
	}

	public void execute(List<String> tokens)
	{
		String chartType = tokens.get(0);

		IObject iObject = null;
		switch(chartType) {

			case "Spreadsheet":
				iObject = new SpreadSheetObject();
				break;
			case "BarChart":
				iObject = new BarChartObject();
				break;
			case "PieChart":
				iObject = new PieChartObject();
				break;
		}

		if (iObject != null)
			spreadSheetApplication.addChart(iObject);
	}

}