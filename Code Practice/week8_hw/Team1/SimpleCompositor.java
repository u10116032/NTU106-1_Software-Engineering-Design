import java.util.*;

public class SimpleCompositor implements Compositor{

	public void compose(Map<Integer, Component> componentMap)
	{
		for (Component component : componentMap.values() ){
			System.out.println("[" + component.getNaturalSize() + "]" + component.getContent());
		}
	}

}