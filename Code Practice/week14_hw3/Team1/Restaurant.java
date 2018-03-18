public class Restaurant {

    private Waitress waitress;
    private LunchMenu lunchMenu;
    private BreakfastMenu breakfastMenu;

    public Restaurant()
    {
        waitress = new Waitress();
        lunchMenu = new LunchMenu();
        breakfastMenu = new BreakfastMenu();
    }

    public void addLunchMenuItem(Item item)
    {
        lunchMenu.addMenuItem(item);
    }

    public void addLunchSubMenu()
    {
        lunchMenu.addSubMenu();
    }
    public void addSubMenuItem(Item item)
    {
        lunchMenu.addSubMenuItem(item);
    }

    public void addBreakfastMenuItem(Item item)
    {
        breakfastMenu.addMenuItem(item);
    }

    public void print()
    {
        waitress.print(lunchMenu, breakfastMenu);
    }
}
