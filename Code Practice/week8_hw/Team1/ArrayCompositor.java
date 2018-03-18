import java.util.*;

public class ArrayCompositor implements Compositor{

	public void compose(Map<Integer, Component> componentMap)
	{
		int count = 0;
		for (Component component : componentMap.values() ){
			System.out.print("[" + component.getNaturalSize() + "]" + component.getContent());

			if ((count + 1) % 3 == 0)
				System.out.println("");
			else {
				if (count != componentMap.size() - 1)
					System.out.print(" ");
			}
			++count;
		}

		if (count != 0)
			System.out.println("");
	}

}