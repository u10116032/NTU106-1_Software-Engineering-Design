import java.util.*;

public abstract class Button extends Widget{
    
    protected String name;

    public Button(String name)
    {
    	super("Button",name);
        this.name = name;
    }

    public abstract void draw();
}
