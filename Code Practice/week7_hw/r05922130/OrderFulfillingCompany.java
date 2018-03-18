public class OrderFulfillingCompany {

	private String companyType;
	private String category;
	private OrderProcessingCompany orderProcessingCompany;

	public OrderFulfillingCompany (String companyType, String category)
	{
		this.companyType = companyType;
		this.category = category;

		switch(category){
			case "CSV":
				orderProcessingCompany = new CSVCompany();
				break;
			case "XML":
				orderProcessingCompany = new XMLCompany();
				break;
			case "Object":
				orderProcessingCompany = new ObjectCompany();
				break;
		}
	}

	public String getCompanyType()
	{
		return this.companyType;
	}

	public String getCategory()
	{
		return this.category;
	}

	public String createOrderInformation(Order order)
	{
		String orderInformation = orderProcessingCompany.createHeader(order) + 
			orderProcessingCompany.createData(order) +
			orderProcessingCompany.createFooter(order);

		return orderInformation;
	}

}