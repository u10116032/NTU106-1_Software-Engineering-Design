public class CarbsVisitor implements Visitor {
    @Override
    public void performOnMenuComponent(MenuComponent m) {
        int layer = m.getLayer();
        String name = m.getName();
        String type = m.getType();
        String equal = "";
        for (int i = 0; i < layer; i++) {
            equal += "=";
        }
        if (type.equals("MenuItem")) {
            String value = String.valueOf( ((MenuItem) m).getCarbs());
            System.out.println(equal + name + " " + value);
        } else {
            System.out.println(equal + name);
            for(MenuComponent c : ((DinerMenu)m).getMenuList()) {
        		c.accept(this);
        	}
        }
    }
}
