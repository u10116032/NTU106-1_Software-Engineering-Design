


import java.util.*;

public class BreakfastIterator extends MyIterator{

	public List<Item> items;

	public int index;

	public BreakfastIterator(BreakfastMenu menu){
		items = menu.itemList;
		index = -1;
	}

	public BreakfastIterator(BreakfastIterator lastIterator) {
		items = lastIterator.items;
		index = lastIterator.index;
	}

	@Override
	public boolean hasNext() {
		if(index + 1 > items.size()-1){
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		if(index  < items.size())
		{
			index++;
			return items.get(index);
		}
		return null;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}

