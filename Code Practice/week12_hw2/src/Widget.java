
public abstract class Widget {
	public String type;
	public String name;
	public Widget(String type,String name){
		this.type = type;
		this.name = name;
	}
	abstract public void draw();
	public String getType() {
		return this.type;
	}
}
