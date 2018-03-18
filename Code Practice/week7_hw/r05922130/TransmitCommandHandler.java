import java.util.*;

public class TransmitCommandHandler implements CommandHandler {

	private OnlineShoppingSite onlineShoppingSite;

	public TransmitCommandHandler(OnlineShoppingSite onlineShoppingSite)
	{
		this.onlineShoppingSite = onlineShoppingSite;
	}
	
	public void execute(List<String> tokens)
	{
		int orderNumber = Integer.parseInt(tokens.get(0));

		onlineShoppingSite.transmit(orderNumber);
	}
}