
public abstract class ScrollBar extends Widget{
	
	private String name;
	
	public ScrollBar(String name)
	{
		super("ScrollBar",name);
		this.setName(name);
	}
	
	abstract public void draw();

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
