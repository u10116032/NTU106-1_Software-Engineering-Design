import java.util.*;

public class Rubric {

	private List<Criteria> criterionList;

	public Rubric(List<Criteria> criterionList)
	{
		this.criterionList = criterionList;
	}

	public int getSize()
	{
		return criterionList.size();
	}

	public Criteria getCriteria(int index)
	{
		return criterionList.get(index);
	}


	public List<Criteria> getCriterionList()
	{
		return this.criterionList;
	}

	public MyIterator getIterator() {
        return new RubricIterator(this);
    }

	public class RubricIterator implements MyIterator{
		private Rubric rubric;
		private int index;

		public RubricIterator(Rubric rubric)
		{
			this.rubric = rubric;
			this.index = 0;
		}

		public boolean hasNext() {
	        if (index < rubric.getSize()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public MyIterator next() {
	        index++;
	        return this;
	    }

	    public String get()
	    {
	    	String criteria = rubric.criterionList.get(index).getName();
	    	Map<String, String> levelDescriptionMap = rubric.criterionList.get(index).getLevelDescriptionMap();

	    	String result = "";
	    	for(Object key: levelDescriptionMap.keySet())
	    	{
	    		result = result + "(" + criteria + "," + key + ") " + levelDescriptionMap.get(key) + "\n";
	    	}
	    	return result;
	    }

	}
}
