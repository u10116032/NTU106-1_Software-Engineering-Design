public class PmWidgetFactory extends WidgetFactory{
  @Override
  public Window createWindow(String name) {
    return new PmWindow(name);
  }

  @Override
  public ScrollBar createScrollBar(String name) {
    return new PmScrollBar(name);
  }

  @Override
  public Button createButton(String name) {
    return new PmButton(name);
  }
}
