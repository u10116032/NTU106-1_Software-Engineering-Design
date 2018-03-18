import java.util.*;
class MotifWindow extends Window{
	public MotifWindow(String name){
		super(name);
	}

	@Override
	public void draw(){
		System.out.println("MotifWindow "+name);
	}
}