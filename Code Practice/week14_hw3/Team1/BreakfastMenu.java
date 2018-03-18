import java.util.ArrayList;
import java.util.Iterator;

public class BreakfastMenu extends Menu{


	public BreakfastMenu(){
		itemList = new ArrayList<Item>();
	}

	public void addMenuItem(Item item){
		addItem(item);
	}

    @Override
	public MyIterator getIterator(){
		return new BreakfastIterator(this);
	}

}
