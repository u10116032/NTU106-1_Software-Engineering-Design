import java.util.*;

public class MotifButton extends Button {
    
    public MotifButton(String name)
    {
        super(name);
    }

    @Override
    public void draw()
    {
        System.out.println("MotifButton " + name);
    }
}
