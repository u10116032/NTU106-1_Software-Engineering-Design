import java.util.ArrayList;
import java.util.List;

public class RubricBuilder {
    List<Criteria> criterionList;
    RubricBuilder() {
        criterionList = new ArrayList<>();
    }
    public RubricBuilder addCriteria(Criteria c) {
        criterionList.add(c);
        return this;
    }
    public Rubric build() {
            return new Rubric(criterionList);
    }
}
