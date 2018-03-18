public class Order{

	private int orderNumber;
	private String orderType;
	private String orderData;

	public Order(int orderNumber, String orderType, String orderData)
	{
		this.orderNumber = orderNumber;
		this.orderType = orderType;
		this.orderData = orderData;
	}

	public int getOrderNumber()
	{
		return this.orderNumber;
	}

	public String getOrderType()
	{
		return this.orderType;
	}

	public String getOrderData()
	{
		return this.orderData = orderData;
	}

}