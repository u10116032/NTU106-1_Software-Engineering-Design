import java.util.*;

public class PieChartObject implements IObject {

	public void update(Map<String, Data> dataMap)
	{
		int sum = 0;
		for (Data data : dataMap.values())
			sum += data.getValue();

		for (Data data : dataMap.values())
			System.out.println(data.getType() + " " + String.format("%.1f", (float)data.getValue() * 100/(float)sum) + "%");
	}

}