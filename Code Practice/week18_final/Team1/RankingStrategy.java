import java.util.*;

public interface RankingStrategy {
  public double computeCriteriaScore(List<Integer> scores);
}
