import java.util.*;

public class SelectCommandHandler implements CommandHandler{

	private Store store;

	public SelectCommandHandler(Store store)
	{
		this.store = store;
	}

	public void execute(List<String> tokens)
	{
		String departmentName = tokens.get(0);
		int month = Integer.parseInt(tokens.get(1));

		Department deparment = store.getDepartment(departmentName);
		
		boolean success = deparment.displayMonthlyReport(month);
		if (success)
			deparment.displayYtdSalesChart();
	}

}