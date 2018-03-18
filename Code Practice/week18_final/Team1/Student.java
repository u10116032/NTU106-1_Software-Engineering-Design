import java.util.*;

public class Student {
	private String id;
	private Map<Assignment, ArrayList<Review>> reviewMap;

	public Student(String id){
		this.id = id;
		reviewMap = new LinkedHashMap<Assignment, ArrayList<Review>>();
	}

	public void addReview(Assignment a, Review r){
		if(reviewMap.get(a) == null)
			reviewMap.put(a, new ArrayList<Review>());
		reviewMap.get(a).add(r);
	}


	public String getId(){
		return id;
	}

	public List<Review> getAssignmentReviews(Assignment a) {
		return reviewMap.get(a);
	}
}
