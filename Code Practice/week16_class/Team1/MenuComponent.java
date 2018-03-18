import java.util.*;

public abstract class MenuComponent implements Acceptor {

    protected String type;
    protected int layer;
    protected String name;

    public MenuComponent(String type, int layer, String name)
    {
        this.type = type;
        this.layer = layer;
        this.name = name;
    }

    public int getLayer()
    {
        return layer;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }
    
    public void accept(Visitor visitor)
    {
        visitor.performOnMenuComponent(this);
    }
    
    public abstract void addMenuComponent(MenuComponent menuComponent);
}
