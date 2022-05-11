package root.stuff.scores;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreHelper {
	static File init() {
		File myFile = new File("./scores.txt");
		try {
			myFile.createNewFile();
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
		ArrayList<Integer> scores = new ArrayList<Integer>();

		try {
			Scanner scanner = new Scanner(init());
			while (scanner.hasNextLine()) {
				Integer data = Integer.valueOf( scanner.nextLine().strip() );
				scores.add(data);
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scores;
	}
}
