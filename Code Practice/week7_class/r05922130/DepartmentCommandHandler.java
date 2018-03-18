import java.util.*;
import java.io.*;

public class DepartmentCommandHandler implements CommandHandler{

	private Store store;

	public DepartmentCommandHandler(Store store)
	{
		this.store = store;
	}

	public void execute(List<String> tokens)
	{
		Department department = store.getDepartment(tokens.get(0));
		department.setName(tokens.get(0));
		tokens.remove(0);

		department.refreshMonthlyReport(tokens);
		department.refreshYtdSalesChart(tokens);
	}

}