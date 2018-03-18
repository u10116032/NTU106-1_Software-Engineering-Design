public abstract class OrderProcessingCompany {

	public OrderProcessingCompany()
	{

	}

	public abstract String createHeader(Order order);

	public abstract String createData(Order order);

	public abstract String createFooter(Order order);

}