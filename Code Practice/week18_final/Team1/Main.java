import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[])
    {
        Map<String, Student> studentMap = new LinkedHashMap<>();
        Map<String, Assignment> assignmentMap = new LinkedHashMap<>();
        List<Review> reviewList = new ArrayList<>();
        Map<String, Integer> schoolStrategy = new LinkedHashMap<>();
        Instructor instructor = new Instructor();

        try{
            File inputFile = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String command;
            while ((command = reader.readLine()) != null){
                List<String> tokens = new ArrayList<>(Arrays.asList(command.split(" ")));
                String type = tokens.get(0);
                tokens.remove(0);

                if (type.equals("student")){
                    for (String studentId : tokens){
                        Student student = new Student(studentId);
                        studentMap.put(studentId, student);
                    }
                }

                else if (type.equals("schoolStrategy")){
                    for (String levelScore : tokens){
                        String level = levelScore.split(",")[0];
                        int score = Integer.parseInt(levelScore.split(",")[1]);

                        schoolStrategy.put(level, score);
                    }
                }

                else if (type.equals("designCriterion")){
                    RubricBuilder builder = new RubricBuilder();

                    String assignmentId = tokens.get(0);
                    String rubricFile = tokens.get(1);

                    File tempFile = new File(rubricFile);
                    BufferedReader tempReader = new BufferedReader(new FileReader(tempFile));

                    String name = "";
                    String tempLine = "";
                    Criteria criteria = null;
                    while((tempLine = tempReader.readLine()) != null){
                        if (!name.equals(tempLine.split("\t")[0])){

                            name = tempLine.split("\t")[0];
                            if (criteria != null){
                                builder.addCriteria(criteria);
                            }

                            criteria = new Criteria(name);
                            criteria.put(tempLine.split("\t")[1], tempLine.split("\t")[2]);
                        }
                        else
                            criteria.put(tempLine.split("\t")[1], tempLine.split("\t")[2]);
                    }
                    if (criteria != null)
                        builder.addCriteria(criteria);

                    Rubric rubric = builder.build();
                    Assignment assignment = new Assignment(assignmentId, rubric);
                    assignmentMap.put(assignmentId, assignment);
                }

                else if (type.equals("assignment")){
                    String assignmentId = tokens.get(0);
                    String studentId = tokens.get(1);
                    tokens.remove(0);
                    tokens.remove(0);

                    if (tokens.size() < 3 || tokens.size() > 5){
                        System.out.println("Assignment should be reviewed by 3-5 students.");
                        continue;
                    }

                    boolean checked = true;
                    for (String line : tokens){
                        if (line.split(",").equals(studentId)){
                            checked = false;
                            break;
                        }

                    }

                    if (!checked)
                        continue;

                    for (String line : tokens){
                        String reviewerId = line.split(",")[0];
                        if (reviewerId.equals(studentId)){
                            System.out.println("Cannot review one’s own assignment.");
                            break;
                        }

                        String sampleScoreFile = line.split(",")[1];
                        Map<String, Integer> criteriaSchoolMap = new LinkedHashMap<>();

                        File tempFile = new File(sampleScoreFile);
                        BufferedReader tempReader = new BufferedReader(new FileReader(tempFile));
                        String tempLine;
                        List<Criteria> criteriaList = assignmentMap.get(assignmentId).getRubric().getCriterionList();

                        System.out.printf("%s-%s was reviewed by %s. Level:", assignmentId, studentId, reviewerId);
                        for (Criteria criteria : criteriaList){
                            String level = tempReader.readLine();
                            criteriaSchoolMap.put(criteria.getName(), schoolStrategy.get(level));
                            System.out.printf(" %s", level);
                        }
                        System.out.println("");
                        Review review = new Review(studentMap.get(studentId), assignmentMap.get(assignmentId), studentMap.get(reviewerId), criteriaSchoolMap);
                        studentMap.get(studentId).addReview(assignmentMap.get(assignmentId), review);
                        assignmentMap.get(assignmentId).addReview(review);
                    }
                }

                else if (type.equals("printRubric")){
                    String assignmentId = tokens.get(0);
                    assignmentMap.get(assignmentId).printRubric();
                }

                else if (type.equals("averageCriterion")){
                    String assignmentId = tokens.get(0);
                    Assignment assignment = assignmentMap.get(assignmentId);
                    Map<String, Double> criteriaMap = instructor.calculateCriteriaAverageScore(assignment);
                    Iterator iterator = criteriaMap.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry pair = (Map.Entry)iterator.next();
                        System.out.println("Assignment: " + assignment.getId() + ", Criterion: " + pair.getKey() + ", AvgScore: " + String.format("%.1f", pair.getValue()).toString());
                    }
                }

                else if (type.equals("calculateScore")){
                    String assignmentId = tokens.get(0);
                    String studentId = tokens.get(1);
                    String strategyType = tokens.get(2);
                    RankingStrategy rankingStrategy;
                    if (strategyType.equals("MeanRankingStrategy"))
                        rankingStrategy = new MeanRankingStrategy();
                    else
                        rankingStrategy = new MedianRankingStrategy();

                    double score = instructor.calculateScore(assignmentMap.get(assignmentId), studentMap.get(studentId), rankingStrategy);
                    System.out.printf("Assignment: %s, Student: %s, Score: %.1f\n", assignmentId, studentId, score);
                }

                else if (type.equals("findStrength")){
                    String assignmentId = tokens.get(0);
                    String studentId = tokens.get(1);
                    String strategyType = tokens.get(2);
                    RankingStrategy rankingStrategy;
                    if (strategyType.equals("MeanRankingStrategy"))
                        rankingStrategy = new MeanRankingStrategy();
                    else
                        rankingStrategy = new MedianRankingStrategy();

                    List<String> strengthList = instructor.findStrength(assignmentMap.get(assignmentId), studentMap.get(studentId), rankingStrategy);
                    System.out.printf("Assignment: %s, Student: %s, Strength:", assignmentId, studentId );
                    for (String strength : strengthList){
                        System.out.printf(" %s", strength);
                    }
                    System.out.println("");
                }

                else if (type.equals("findWeakness")){

                    String assignmentId = tokens.get(0);
                    String studentId = tokens.get(1);
                    String strategyType = tokens.get(2);
                    RankingStrategy rankingStrategy;
                    if (strategyType.equals("MeanRankingStrategy"))
                        rankingStrategy = new MeanRankingStrategy();
                    else
                        rankingStrategy = new MedianRankingStrategy();

                    List<String> weaknessList = instructor.findWeakness(assignmentMap.get(assignmentId), studentMap.get(studentId), rankingStrategy);
                    System.out.printf("Assignment: %s, Student: %s, Weakness:", assignmentId, studentId );
                    for (String weakness : weaknessList){
                        System.out.printf(" %s", weakness);
                    }
                    System.out.println("");
                }

                else{
                    System.out.println("No such command: " + type);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
