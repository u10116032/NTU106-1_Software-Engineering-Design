import java.util.*;

public class Review {
	private Student student;
	private Assignment assignment;
	private Student reviewer;
	private Map<String, Integer> criteriaScoreMap;

	public Review(Student s,
			Assignment a,
			Student r,
			Map<String, Integer> m){
		student = s;
		assignment = a;
		reviewer = r;
		this.criteriaScoreMap = m;
	}

	public Student getStudent(){
		return this.student;
	}

	public Assignment getAssignment(){
		return this.assignment;
	}

	public Student getReviewer(){
		return this.reviewer;
	}

	public Map<String, Integer> getScoreMap(){
		return this.criteriaScoreMap;
	}
}
