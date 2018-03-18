import java.util.*;
abstract class Window extends Widget{
	protected String name;
	public Window(String name){
		super("Window",name);
		this.name=name;
	}
	abstract public void draw();
}