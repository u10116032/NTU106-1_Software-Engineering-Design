import java.util.*;

public class Composition {

	private Map<Integer, Component> componentMap;
	private Compositor compositor;

	public Composition()
	{
		this.componentMap = new LinkedHashMap<Integer, Component>();
	}

	public void addComponent(Component component)
	{
		componentMap.put(component.getComponentId(), component);
	}

	public Component getComponent(int componentId)
	{
		return componentMap.get(componentId);
	}

	public void setCompositor(Compositor compositor)
	{
		this.compositor = compositor;
	}

	public void compose()
	{
		if(compositor != null)
			compositor.compose(componentMap);
		else
			System.out.println("No compositor found.");
	}
}