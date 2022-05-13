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

	/**
	 * @return the most recent 10 scores
	 */
	public static ArrayList<Integer> getScores() {
	
		ArrayList<Integer> scores = new ArrayList<Integer>();

		try {
			Scanner scanner = new Scanner(init());
			int i = 0;
			while (scanner.hasNextLine() && i < 10) {
				Integer data = Integer.valueOf( scanner.nextLine().strip() );
				scores.add(data);
				i++;
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scores;
	}
}
