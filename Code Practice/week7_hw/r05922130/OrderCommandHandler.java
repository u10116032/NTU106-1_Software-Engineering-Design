import java.util.*;

public class OrderCommandHandler implements CommandHandler {

	private OnlineShoppingSite onlineShoppingSite;

	public OrderCommandHandler(OnlineShoppingSite onlineShoppingSite)
	{
		this.onlineShoppingSite = onlineShoppingSite;
	}
	
	public void execute(List<String> tokens)
	{
		int orderNumber = Integer.parseInt(tokens.get(0));
		String orderType = tokens.get(1);
		String orderData = tokens.get(2);

		Order order = new Order(orderNumber, orderType, orderData);
		onlineShoppingSite.addOrder(order);
	}
}