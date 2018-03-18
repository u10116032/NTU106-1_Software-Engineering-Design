import java.util.*;

public class SpreadSheetObject implements IObject {

	public void update(Map<String, Data> dataMap)
	{
		for (Data data : dataMap.values())
			System.out.println(data.getType() + " " + data.getValue());
	}

}