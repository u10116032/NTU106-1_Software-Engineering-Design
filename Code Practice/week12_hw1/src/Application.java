import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Document> documentList;
    Application() {
        documentList = new ArrayList<>();
    }
    public void present() {
        for (Document document: documentList) {
            document.display();
        }
    }
    public void create(Document document) {
        documentList.add(document);
    }

}
