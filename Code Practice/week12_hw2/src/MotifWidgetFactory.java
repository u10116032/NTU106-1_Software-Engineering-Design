public class MotifWidgetFactory extends WidgetFactory{
  @Override
  public Window createWindow(String name) {
    return new MotifWindow(name);
  }

  @Override
  public ScrollBar createScrollBar(String name) {
    return new MotifScrollBar(name);
  }

  @Override
  public Button createButton(String name) {
    return new MotifButton(name);
  }
}
