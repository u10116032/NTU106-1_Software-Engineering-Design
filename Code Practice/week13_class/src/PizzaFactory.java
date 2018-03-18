import java.util.*;

public abstract class PizzaFactory {

    protected String dough;
    protected String sauce;

    public PizzaFactory(String dough, String sauce)
    {
        this.dough = dough;
        this.sauce = sauce;
    }

    public abstract Pizza createPizza(String type);
}
