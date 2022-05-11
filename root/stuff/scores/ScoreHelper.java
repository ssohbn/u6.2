package root.stuff.scores;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScoreHelper {
	static File init() {
		File myFile = new File("./scores.txt");
		try {
			myFile.createNewFile();
			System.out.println("created file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myFile;
	}

	public static void submitScore(int score) {
		try {
			FileWriter writer = new FileWriter(init(), true);
			writer.write(""+score+"\n");
			writer.close();
			System.out.println("wrote scores");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> getScores() {
		return null;
	}
}
