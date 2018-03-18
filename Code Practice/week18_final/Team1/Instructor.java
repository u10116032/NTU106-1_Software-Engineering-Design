import java.util.*;

public class Instructor {
  public Map<String, Double> calculateCriteriaAverageScore(Assignment assignment) {
    Map<String, Double> criteriaAverageScoreMap = new LinkedHashMap<>();
    List<Review> reviews = assignment.getReviews();
    for (Review review : reviews) {
      Map<String, Integer> reviewCriteriaScoreMap = review.getScoreMap();
      for (String criteria : reviewCriteriaScoreMap.keySet()) {
          if (!criteriaAverageScoreMap.containsKey(criteria))
            criteriaAverageScoreMap.put(criteria, 0.0);

        criteriaAverageScoreMap.put(criteria,
        criteriaAverageScoreMap.get(criteria) + reviewCriteriaScoreMap.get(criteria));
      }
    }
    for (String criteria : criteriaAverageScoreMap.keySet()) {
      criteriaAverageScoreMap.put(criteria, criteriaAverageScoreMap.get(criteria) / (double) reviews.size());
    }
    return criteriaAverageScoreMap;
  }

  public double calculateScore(Assignment assignment, Student student, RankingStrategy strategy) {
    Map<String, List<Integer>> criteriaScoresMap = new LinkedHashMap<>();
    List<Review> reviews = student.getAssignmentReviews(assignment);
    for (Review review : reviews) {
      Map<String, Integer> criteraScoreMap = review.getScoreMap();
      for (String criteria : criteraScoreMap.keySet()) {
        if (!criteriaScoresMap.containsKey(criteria)) {
          criteriaScoresMap.put(criteria, new ArrayList<>());
        }
        criteriaScoresMap.get(criteria).add(criteraScoreMap.get(criteria));
      }
    }
    Map<String, Double> criteriaComputedScoreMap = new LinkedHashMap<>();
    for (String criteria : criteriaScoresMap.keySet()) {
      criteriaComputedScoreMap.put(criteria, strategy.computeCriteriaScore(criteriaScoresMap.get(criteria)));
    }
    double averageScore = 0;
    for (String criteria : criteriaComputedScoreMap.keySet()) {
      averageScore += criteriaComputedScoreMap.get(criteria);
    }
    averageScore /= (double) criteriaComputedScoreMap.size();
    return averageScore;
  }

  public List<String> findStrength(Assignment assignment, Student student, RankingStrategy strategy) {
    Map<String, List<Integer>> criteriaScoresMap = new LinkedHashMap<>();
    List<Review> reviews = student.getAssignmentReviews(assignment);
    for (Review review : reviews) {
      Map<String, Integer> criteraScoreMap = review.getScoreMap();
      for (String criteria : criteraScoreMap.keySet()) {
        if (!criteriaScoresMap.containsKey(criteria)) {
          criteriaScoresMap.put(criteria, new ArrayList<>());
        }
        criteriaScoresMap.get(criteria).add(criteraScoreMap.get(criteria));
      }
    }
    Map<String, Double> criteriaComputedScoreMap = new LinkedHashMap<>();
    for (String criteria : criteriaScoresMap.keySet()) {
      criteriaComputedScoreMap.put(criteria, strategy.computeCriteriaScore(criteriaScoresMap.get(criteria)));
    }
    double maxScore = 0;
    for (String criteria : criteriaComputedScoreMap.keySet()) {
      if (criteriaComputedScoreMap.get(criteria) > maxScore) {
        maxScore = criteriaComputedScoreMap.get(criteria);
      }
    }
    List<String> strengths = new ArrayList<>();
    for (String criteria : criteriaComputedScoreMap.keySet()) {
      if (criteriaComputedScoreMap.get(criteria).equals(maxScore)) {
        strengths.add(criteria);
      }
    }
    return strengths;
  }

  public List<String> findWeakness(Assignment assignment, Student student, RankingStrategy strategy) {
    Map<String, List<Integer>> criteriaScoresMap = new LinkedHashMap<>();
    List<Review> reviews = student.getAssignmentReviews(assignment);
    for (Review review : reviews) {
      Map<String, Integer> criteraScoreMap = review.getScoreMap();
      for (String criteria : criteraScoreMap.keySet()) {
        if (!criteriaScoresMap.containsKey(criteria)) {
          criteriaScoresMap.put(criteria, new ArrayList<>());
        }
        criteriaScoresMap.get(criteria).add(criteraScoreMap.get(criteria));
      }
    }
    Map<String, Double> criteriaComputedScoreMap = new LinkedHashMap<>();
    for (String criteria : criteriaScoresMap.keySet()) {
      criteriaComputedScoreMap.put(criteria, strategy.computeCriteriaScore(criteriaScoresMap.get(criteria)));
    }
    double minScore = Double.MAX_VALUE;
    for (String criteria : criteriaComputedScoreMap.keySet()) {
      if (criteriaComputedScoreMap.get(criteria) < minScore) {
        minScore = criteriaComputedScoreMap.get(criteria);
      }
    }
    List<String> weaknesses = new ArrayList<>();
    for (String criteria : criteriaComputedScoreMap.keySet()) {
      if (criteriaComputedScoreMap.get(criteria).equals(minScore)) {
        weaknesses.add(criteria);
      }
    }
    return weaknesses;
  }
}
