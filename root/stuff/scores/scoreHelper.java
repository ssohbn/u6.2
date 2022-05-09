package root.stuff.scores;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScoreHelper {
	File init() {
		return new File("scores.txt");

	}
	public static void submitScore(int score) {
		try {
			FileWriter writer = new FileWriter("scores.txt", true); // true means append to end of file
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
