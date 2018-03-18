public class Transaction{
	private String productName;
	private int price;

	public Transaction(String productName, int price)
	{
		this.productName = productName;
		this.price = price;
	}

	public String getProductName()
	{
		return productName;
	}

	public int getPrice()
	{
		return price;
	}
}