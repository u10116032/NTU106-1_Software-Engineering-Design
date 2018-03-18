import java.util.*;

public class Store{
	private Map<String, Department> departmentMap;

	public Store()
	{
		departmentMap = new HashMap<String, Department>();
	}

	public Department getDepartment(String departmentName)
	{
		if(!departmentMap.containsKey(departmentName)){
			Department department = new Department();
			departmentMap.put(departmentName, department);
		}

		return departmentMap.get(departmentName);
	}
}