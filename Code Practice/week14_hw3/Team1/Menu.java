import java.util.*;

public class Menu implements MyIterable {
    public List<Item> itemList;

    protected Menu()
    {
        itemList = new ArrayList<Item>();
    }

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public MyIterator getIterator()
    {
        return null;
    }

}
