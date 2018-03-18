import java.util.*;

public class MonthlyReport implements IReport{
	
	private Department department;
	private Map<Integer, List<Transaction>> transactionMap;


	public MonthlyReport(Department department)
	{
		this.department = department;
		transactionMap = new TreeMap<Integer, List<Transaction>>();
	}

	public void refresh(List<String> tokens)
	{
		int month = Integer.parseInt(tokens.get(0));
		List<Transaction> transactionList = transactionMap.get(month);
		if (transactionList == null)
			transactionList = new ArrayList<Transaction>();

		for (int i = 1; i < tokens.size(); ++i){
			String productName = tokens.get(i).split(",")[0];
			int price = Integer.parseInt(tokens.get(i).split(",")[1]);
			transactionList.add(new Transaction(productName, price));
		}

		transactionMap.put(month, transactionList);
	}

	public boolean display()
	{
		int month = department.getDisplayMonth();

		List<Transaction> transactionList = transactionMap.get(month);

		if (transactionList == null){
			System.out.println("no data in selected month!");
			return false;
		}

		String departmentName = department.getName();
		System.out.println("display MonthlyReport for " + departmentName + " month " + Integer.toString(month));
		for (Transaction transaction : transactionList){
			System.out.println(transaction.getProductName() + " " + Integer.toString(transaction.getPrice()));
		}
		return true;
	}

}