import java.util.*;
class PmWindow extends Window{

	public PmWindow(String name){
		super(name);
	}
	
	@Override
	public void draw(){
		System.out.println("PMWindow "+name);
	}
}