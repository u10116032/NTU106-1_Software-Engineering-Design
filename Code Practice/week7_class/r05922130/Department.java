import java.util.*;

public class Department{
	
	private IReport monthlyReport;
	private IReport ytdSalesChart;

	private int displayMonth;
	private String name;

	public Department()
	{
		monthlyReport = new MonthlyReport(this);
		ytdSalesChart = new YTDSalesChart(this);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void refreshMonthlyReport(List<String> tokens)
	{
		monthlyReport.refresh(tokens);
	}

	public void refreshYtdSalesChart(List<String> tokens)
	{
		ytdSalesChart.refresh(tokens);
	}

	public boolean displayMonthlyReport(int month)
	{
		this.displayMonth = month;
		return monthlyReport.display();
	}

	public boolean displayYtdSalesChart()
	{
		return ytdSalesChart.display();
	}

	public int getDisplayMonth()
	{
		return displayMonth;
	}
}