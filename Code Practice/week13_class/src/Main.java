import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		
		String flavor, style;
		PizzaStore pizzaStore = new PizzaStore();
		
		File file = new File(args[0]);
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			
			while((line=reader.readLine())!=null){
				String[] words = line.split(" ");
				flavor = words[0];
				style = words[1];
				
				if(style.equals("Chicago"))
				{
					pizzaStore.pizzaFactory = new ChicagoPizzaFactory();
					pizzaStore.pizza = pizzaStore.pizzaFactory.createPizza(flavor);
				}
				if(style.equals("NY"))
				{
					pizzaStore.pizzaFactory = new NyPizzaFactory();
					pizzaStore.pizza = pizzaStore.pizzaFactory.createPizza(flavor);
				}

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
