import java.util.*;

public class TextCompositor implements Compositor{

	public void compose(Map<Integer, Component> componentMap)
	{
		boolean isBreakLine = false;
		for (Component component : componentMap.values()){
			System.out.print("[" + component.getNaturalSize() + "]" + component.getContent());

			isBreakLine = false;
			if (component.getContent().equals("<ParagraphEnd>")){
				System.out.println("");
				isBreakLine = true;
			}
			else
				System.out.print(" ");
		}

		if(!isBreakLine)
			System.out.println("");
	}

}