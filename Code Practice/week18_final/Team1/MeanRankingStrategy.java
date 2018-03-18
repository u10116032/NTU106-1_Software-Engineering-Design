import java.util.*;

public class MeanRankingStrategy implements RankingStrategy {
  public double computeCriteriaScore(List<Integer> scores) {
    double averageScore = 0;
    for (Integer score : scores) {
      averageScore += score;
    }
    averageScore /= (double)scores.size();
    return averageScore;
  }
}
