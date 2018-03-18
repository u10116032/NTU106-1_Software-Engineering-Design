import java.util.*;

public class CompanyCommandHandler implements CommandHandler {

	private OnlineShoppingSite onlineShoppingSite;

	public CompanyCommandHandler(OnlineShoppingSite onlineShoppingSite)
	{
		this.onlineShoppingSite = onlineShoppingSite;
	}

	public void execute(List<String> tokens)
	{
		String companyType = tokens.get(0);
		String category = tokens.get(1);

		OrderFulfillingCompany orderFulfillingCompany = new OrderFulfillingCompany(companyType, category);
		onlineShoppingSite.addOrderFulfillingCompany(orderFulfillingCompany);
	}
}