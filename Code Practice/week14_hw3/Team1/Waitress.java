import java.util.*;

public class Waitress {

    public Waitress(){}

    public void print(LunchMenu lunchMenu, BreakfastMenu breakfastMenu)
    {
        MyIterator iterator = breakfastMenu.getIterator();
        if (iterator.hasNext())
            System.out.println("PancakeHouseMenu:");
        while (iterator.hasNext()){
            Item item = (Item)iterator.next();
            System.out.println("MenuItem:" + item.getValue());
        }

        iterator = lunchMenu.getIterator();
        if (iterator.hasNext())
            System.out.println("DinerMenu:");
        while(iterator.hasNext()){
            Item item = (Item)iterator.next();

            if (iterator.isNew())
                System.out.println("SubMenu:");

            System.out.println("MenuItem:" + item.getValue());
        }
    }
}
