import java.util.*;

public class SpreadSheetApplication {

	private Map<String, Data> dataMap;
	private List<IObject> iObjectList;

	public SpreadSheetApplication()
	{
		dataMap = new LinkedHashMap<String, Data>();
		iObjectList = new ArrayList<IObject>();
	}

	public void addData(String type, Data data)
	{
		dataMap.put(type, data);
	}
	public void addChart(IObject iObject)
	{
		iObjectList.add(iObject);
	}

	public void change(String charType, String item, int value)
	{
		if (dataMap.containsKey(item))
			dataMap.get(item).setValue(value);
		else {
			Data data = new Data(item, value);
			dataMap.put(item, data);
		}

		for (IObject iObject : iObjectList)
			iObject.update(dataMap);
	}

}