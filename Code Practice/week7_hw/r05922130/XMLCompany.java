public class XMLCompany extends OrderProcessingCompany {

	public XMLCompany()
	{
		
	}

	@Override
	public String createHeader(Order order)
	{
		return "<XML header>";
	}

	@Override
	public String createData(Order order)
	{
		return order.getOrderData();
	}

	@Override
	public String createFooter(Order order)
	{
		return "<XML footer>";
	}
}