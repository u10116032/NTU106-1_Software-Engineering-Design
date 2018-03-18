import java.util.LinkedHashMap;
import java.util.Map;

public class Criteria {
    private String name;
    private Map<String, String> levelDescriptionMap;
    Criteria(String name) {
        this.name = name;
        levelDescriptionMap = new LinkedHashMap<>();
    }
    public String getName() {
        return name;
    }
    public Map getLevelDescriptionMap() {
        return levelDescriptionMap;
    }

    public void put(String level, String description)
    {
        levelDescriptionMap.put(level, description);
    }

}
