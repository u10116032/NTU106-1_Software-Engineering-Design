import java.util.*;

public class PmButton extends Button {
    
    public PmButton(String name)
    {
        super(name);
    }

    @Override
    public void draw()
    {
        System.out.println("PMButton " + name);
    }
}
