import java.util.*;

public class MedianRankingStrategy implements RankingStrategy {
  public double computeCriteriaScore(List<Integer> scores) {
    Collections.sort(scores);
    if (scores.size() % 2 == 1) {
      return scores.get(scores.size() / 2);
    }
    return (scores.get(scores.size() / 2 - 1) + scores.get(scores.size() / 2)) / 2;
  }
}
