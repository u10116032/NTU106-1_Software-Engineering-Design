import java.util.*;

public class DinerMenu extends MenuComponent {

    private List<MenuComponent> menuList;
    
    public DinerMenu(int layer, String name)
    {
        super("DinerMenu", layer, name);

        menuList = new ArrayList<MenuComponent>();
    }

    public List<MenuComponent> getMenuList()
    {
        return menuList;
    }

	@Override
	public void addMenuComponent(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		menuList.add(menuComponent);
		
	}

}
