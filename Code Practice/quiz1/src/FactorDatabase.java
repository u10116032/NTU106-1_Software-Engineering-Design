import java.util.*;
import java.io.*;

public class FactorDatabase {

	public static final int SAFE = 0;
	public static final int DANGEROUS = 1;
	public static final int FAIL = 2;

	private String sensorCategory;
	private String sensorName;
	private float lowerBound;
	private float upperBound;

	private List<Float> recordList;

	public FactorDatabase(String sensorCategory, String sensorName, String filePath, float lowerBound, float upperBound)
	{
		this.sensorCategory = sensorCategory;
		this.sensorName = sensorName;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;

		recordList = new ArrayList<>();
		readDatabase(filePath);
	}

	private void readDatabase(String filePath)
	{	try{
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String element;
			while ((element = reader.readLine()) != null){
				recordList.add(Float.parseFloat(element));
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public int checkStatus(int index)
	{
		if (index >= recordList.size())
			return FactorDatabase.FAIL;

		float value = recordList.get(index);

		if (value == -1)
			return FactorDatabase.FAIL;
		else if(value > upperBound || value < lowerBound)
			return FactorDatabase.DANGEROUS;
		else
			return FactorDatabase.SAFE;
	}

	public float getRecord(int index)
	{
		if(index >= recordList.size())
			return -1.0f;

		return recordList.get(index);
	}

	public String getSensorCategory()
	{
		return this.sensorCategory;
	}

	public String getSensorName()
	{
		return this.sensorName;
	}

	public float getLowerBound()
	{
		return this.lowerBound;
	}

	public float getUpperBound()
	{
		return this.upperBound;
	}

}