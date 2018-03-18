import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            File file = new File(args[0]);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            Application application = new Application();
            while((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                if (temp[0].equals("Draw")) {
                    application.create(new DrawingDocument());
                } else if (temp[0].equals("Text")) {
                    application.create(new TextDocument());
                } else if (temp[0].equals("Present")) {
                    application.present();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
