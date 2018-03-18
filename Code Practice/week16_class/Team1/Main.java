import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(args[0]);
		BufferedReader reader;

		DinerMenu dm = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			while((line=reader.readLine())!=null){
				String[] words = line.split(" ");

				if(words[0].equals("diner"))
				{

					int layer = Integer.valueOf(words[1]);
					String name = words[2];

					if(layer==0)
					{
						dm = new DinerMenu(layer, name);
					}
					else dm.addMenuComponent( new DinerMenu(layer, name) );
				}
				else if(words[0].equals("item"))
				{
					int layer = Integer.valueOf(words[1]);
					String name = words[2];
					int calories = Integer.valueOf(words[3]);
					int protein = Integer.valueOf(words[4]);
					int carbs = Integer.valueOf(words[5]);

					dm.addMenuComponent( new MenuItem(layer, name, calories, protein, carbs) );
				}
				else if(words[0].equals("printCalories"))
				{
					CaloriesVisitor caloriesVisitor = new CaloriesVisitor();
					dm.accept(caloriesVisitor);
				}
				else if(words[0].equals("printProtein"))
				{
					ProteinVisitor proteinVisitor = new ProteinVisitor();
					dm.accept(proteinVisitor);
				}
				else if(words[0].equals("printCarbs"))
				{
					CarbsVisitor carbsVisitor = new CarbsVisitor();
					dm.accept(carbsVisitor);
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
