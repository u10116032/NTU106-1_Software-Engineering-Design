import java.util.ArrayList;

public class Assignment {
	private String id;
	private Rubric rubric;
	private ArrayList<Review> reviews;

	public Assignment(String id, Rubric rubric){
		this.id = id;
		this.rubric = rubric;
		reviews = new ArrayList<Review>();
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setRubric(Rubric rubric){
		this.rubric = rubric;
	}

	public Rubric getRubric(){
		return rubric;
	}

	public void addReview(Review review){
		reviews.add(review);
	}

	public ArrayList<Review> getReviews(){
		return reviews;
	}

	public void printRubric(){
		MyIterator it = rubric.getIterator();
		while(it.hasNext()){
			String temp = it.get();
			System.out.print(temp);
			it = it.next();
		}

	}
}
