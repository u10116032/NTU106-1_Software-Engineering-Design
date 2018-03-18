import java.util.*;

public class BarChartObject implements IObject {

	public void update(Map<String, Data> dataMap)
	{
		for (Data data : dataMap.values()){
			for (int i = 0; i < data.getValue(); ++i)
				System.out.print("=");
			System.out.println(" " + data.getType());
		}
	}

}