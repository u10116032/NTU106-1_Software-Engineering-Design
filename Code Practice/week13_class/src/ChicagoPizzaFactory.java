import java.util.*;

public class ChicagoPizzaFactory extends PizzaFactory {

    public ChicagoPizzaFactory()
    {
        super("ThickCrustDough", "PlumTomatoSauce");
    }

    @Override
    public Pizza createPizza(String type)
    {
        System.out.println("Prepare " + type + " Pizza with " + dough + " and " + sauce);
        switch (type){
            case "Cheese":{
                return new ChicagoCheesePizza(dough, sauce);
            }
            case "Pepperoni":{
                return new ChicagoPepperoniPizza(dough, sauce);
            }
        }
        return null;
    }

}
