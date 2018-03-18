public class CSVCompany extends OrderProcessingCompany {

	public CSVCompany()
	{
		
	}

	@Override
	public String createHeader(Order order)
	{
		return "<CSV header>";
	}

	@Override
	public String createData(Order order)
	{
		return order.getOrderData();
	}

	@Override
	public String createFooter(Order order)
	{
		return "<CSV footer>";
	}
}