import java.util.*;

public class LunchIterator extends MyIterator {

	public List<Item> items;
	public List<Menu> subMenus;

	public int index;
    public int subMenuIndex;
	public int subMenuItemIndex;

	public LunchIterator(LunchMenu menu)
    {
		items = menu.itemList;
		subMenus = menu.subMenus;
		index = -1;
		subMenuIndex = 0;
        subMenuItemIndex = -1;
	}


	@Override
	public boolean hasNext() {
		if(index  < items.size()-1)
            return true;
        else if (subMenus.size() == 0)
            return false;
        else if ((subMenuIndex >= subMenus.size()-1) && (subMenuItemIndex >= subMenus.get(subMenuIndex).itemList.size()-1) )
            return false;
        else
            return true;
	}

	@Override
	public Object next() {
		if(index  < items.size()-1)
		{
			index++;
			return items.get(index);
		}
		else
		{
            if (subMenuItemIndex == subMenus.get(subMenuIndex).itemList.size() - 1){
                subMenuIndex++;
                subMenuItemIndex = 0;
            }
            else
                subMenuItemIndex++;

            return subMenus.get(subMenuIndex).itemList.get(subMenuItemIndex);
		}
	}


	public boolean isNew(){
		if(index == items.size()-1 && subMenuIndex <= subMenus.size() && subMenuItemIndex == 0)
			return true;
		return false;
	}

}
