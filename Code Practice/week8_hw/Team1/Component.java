public abstract class Component{

	protected int componentId;
	protected int naturalSize;
	protected int stretchability;
	protected int shrinkability;
	protected String content;

	public Component(int componentId, int naturalSize, int stretchability, int shrinkability, String content)
	{
		this.componentId = componentId;
		this.naturalSize = naturalSize;
		this.stretchability = stretchability;
		this.shrinkability = shrinkability;
		this.content = content;
	}

	public void changeSize(int newSize)
	{
		if (newSize < shrinkability || stretchability < newSize)
			System.out.println("component " + componentId + " failed to change size");
		else{
			this.naturalSize = newSize;
			System.out.println("component " + componentId + " size changed to "+ newSize);
		}
	}
	
	public int getComponentId()
	{
		return componentId;
	}

	public int getNaturalSize()
	{
		return naturalSize;
	}

	public int getStretchability()
	{
		return stretchability;
	}

	public int getShrinkability()
	{
		return shrinkability;
	}

	public String getContent()
	{
		return content;
	}

}