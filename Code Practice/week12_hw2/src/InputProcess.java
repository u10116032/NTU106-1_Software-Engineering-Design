import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputProcess {
	static ArrayList getInput(String filename) throws IOException {
		String line = "";
		File InputFile = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(InputFile));
		
		ArrayList<String> Input = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			Input.add(line);
		}
		return Input;
	}
}
