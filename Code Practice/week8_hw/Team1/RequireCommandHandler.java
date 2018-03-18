import java.util.*;

public class RequireCommandHandler implements CommandHandler{

	private Composition composition;

	public RequireCommandHandler(Composition composition)
	{
		this.composition = composition;
	}

	public void execute(List<String> tokens)
	{
		String breakStrategy = tokens.get(0);

		switch (breakStrategy){
			case "SimpleComposition":
				composition.setCompositor(new SimpleCompositor());
				break;
			case "TexComposition":
				composition.setCompositor(new TextCompositor());
				break;
			case "ArrayComposition":
				composition.setCompositor(new ArrayCompositor());
				break;
		}
		composition.compose();
	}
}