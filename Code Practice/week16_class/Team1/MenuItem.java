import java.util.*;

public class MenuItem extends MenuComponent {

    private int calories;
    private int protein;
    private int carbs;

    public MenuItem(int layer, String name, int calories, int protein, int carbs)
    {
        super("MenuItem", layer, name);

        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
    }

    public int getCalories()
    {
        return calories;
    }

    public int getProtein()
    {
        return protein;
    }

    public int getCarbs()
    {
        return carbs;
    }

    @Override
    public void addMenuComponent(MenuComponent menuComponent){}

}
