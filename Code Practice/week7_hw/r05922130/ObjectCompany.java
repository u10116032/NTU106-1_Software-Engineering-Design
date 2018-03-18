public class ObjectCompany extends OrderProcessingCompany {

	public ObjectCompany()
	{

	}

	@Override
	public String createHeader(Order order)
	{
		return "<Object header>";
	}

	@Override
	public String createData(Order order)
	{
		return order.getOrderData();
	}

	@Override
	public String createFooter(Order order)
	{
		return "<Object footer>";
	}
}