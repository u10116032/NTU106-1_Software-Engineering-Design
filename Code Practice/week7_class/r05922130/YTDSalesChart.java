import java.util.*;

public class YTDSalesChart implements IReport{
	
	private Department department;
	private Map<Integer, Integer> totalPriceMap;

	public YTDSalesChart(Department department)
	{
		this.department = department;
		totalPriceMap = new HashMap<Integer, Integer>();
	}

	public void refresh(List<String> tokens)
	{
		int month = Integer.parseInt(tokens.get(0));
		tokens.remove(0);

		int totalPrice = 0;
		for (int i = 0; i < tokens.size(); ++i){

			String productName = tokens.get(i).split(",")[0];
			int price = Integer.parseInt(tokens.get(i).split(",")[1]);

			totalPrice += price;
		}

		totalPriceMap.put(month, totalPrice);
	}

	public boolean display()
	{
		String departmentName = department.getName(); 
		System.out.println("display YTDSalesChart for " + departmentName);
		for (Integer key : totalPriceMap.keySet()) 
		    System.out.println("month " + Integer.toString(key) + " price " + Integer.toString(totalPriceMap.get(key)));
		return true;
	}

}