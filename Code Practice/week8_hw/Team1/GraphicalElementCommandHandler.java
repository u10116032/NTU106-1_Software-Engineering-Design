import java.util.*;

public class GraphicalElementCommandHandler implements CommandHandler{

	private Composition composition;

	public GraphicalElementCommandHandler(Composition composition)
	{
		this.composition = composition;
	}

	public void execute(List<String> tokens)
	{
		int componentId = Integer.parseInt(tokens.get(0));
		int naturalSize = Integer.parseInt(tokens.get(1));
		int shrinkability = Integer.parseInt(tokens.get(2));
		int stretchability = Integer.parseInt(tokens.get(3));
		String content = tokens.get(4);

		Component component = new GraphicalElement(componentId, naturalSize, stretchability, shrinkability, content);
		composition.addComponent(component);
	}
}