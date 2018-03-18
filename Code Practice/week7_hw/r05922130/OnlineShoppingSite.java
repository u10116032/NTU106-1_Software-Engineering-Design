import java.util.*;
import java.io.*;

public class OnlineShoppingSite {

	private Map<String, CommandHandler> commandMap;
	private Map<String, OrderFulfillingCompany> orderFulfillingCompanyMap;
	private Map<Integer, Order> orderMap;

	public OnlineShoppingSite()
	{
		commandMap = new HashMap<String, CommandHandler>();
		commandMap.put("company", new CompanyCommandHandler(this));
		commandMap.put("order", new OrderCommandHandler(this));
		commandMap.put("transmit", new TransmitCommandHandler(this));

		orderFulfillingCompanyMap = new HashMap<String, OrderFulfillingCompany>();
		orderMap = new HashMap<Integer, Order>();
	}

	public void start(String inputFileName)
	{
		try{
			File inputFile = new File(inputFileName);
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String command;
			while ((command = reader.readLine()) != null){
				List<String> tokens = CommandTokenizer.INSTANCE.parse(command);
				String commandType = tokens.get(0);
				tokens.remove(0);

				commandMap.get(commandType).execute(tokens);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void addOrder(Order order)
	{
		String orderType = order.getOrderType();
		if (!orderFulfillingCompanyMap.containsKey(orderType)){
			System.out.println("no company can fulfill such order!");
			return;
		}

		orderMap.put(order.getOrderNumber(), order);

		OrderFulfillingCompany orderFulfillingCompany = orderFulfillingCompanyMap.get(orderType);
		System.out.println("order " + 
			order.getOrderNumber() + 
			": " + 
			orderType +
			" order created in " +
			orderFulfillingCompany.getCategory() +
			" format");
	}

	public void addOrderFulfillingCompany(OrderFulfillingCompany orderFulfillingCompany)
	{
		orderFulfillingCompanyMap.put(orderFulfillingCompany.getCompanyType(), orderFulfillingCompany);
	}

	public void transmit(int orderNumber)
	{
		if (!orderMap.containsKey(orderNumber)){
			System.out.println("no such order!");
			return;
		}

		Order order = orderMap.get(orderNumber);
		OrderFulfillingCompany orderFulfillingCompany = orderFulfillingCompanyMap.get(order.getOrderType());

		System.out.println(order.getOrderType() + " company receive order " + order.getOrderNumber() + ":");
		System.out.println(orderFulfillingCompany.createOrderInformation(order));
	}

}