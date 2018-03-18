public class Data {
	
	private String type;
	private int value;

	public Data(String type, int value)
	{
		this.type = type;
		this.value = value;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

}