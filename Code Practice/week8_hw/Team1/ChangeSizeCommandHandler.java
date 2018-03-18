import java.util.*;

public class ChangeSizeCommandHandler implements CommandHandler{

	private Composition composition;

	public ChangeSizeCommandHandler(Composition composition)
	{
		this.composition = composition;
	}

	public void execute(List<String> tokens)
	{
		int componentId = Integer.parseInt(tokens.get(0));
		int newSize = Integer.parseInt(tokens.get(1));

		Component component = composition.getComponent(componentId);
		component.changeSize(newSize);
	}
}