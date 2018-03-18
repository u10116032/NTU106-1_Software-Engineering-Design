import java.util.*;

public class LunchMenu extends Menu {
    public List<Menu> subMenus;

    public LunchMenu()
    {
        subMenus = new ArrayList<Menu>();
    }

    public void addSubMenu()
    {
        subMenus.add(new Menu());
    }

    public void addSubMenuItem(Item item)
    {
        Menu menu = subMenus.get(subMenus.size()-1);
        menu.addItem(item);
    }

    public void addMenuItem(Item item)
    {
        addItem(item);
    }

    @Override
    public MyIterator getIterator()
    {
        return new LunchIterator(this);
    }

}
