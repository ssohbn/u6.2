package root.stuff.scores;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;

public class scoreHelper {

	public static void submitScore() {
		try {
			FileWriter writer = new FileWriter("scores.txt");
			writer.write("scores");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Integer> getScores() {
		return null;
	}
}
