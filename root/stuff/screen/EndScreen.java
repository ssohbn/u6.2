package root.stuff.screen;

import java.util.ArrayList;
import java.util.Collections;

import root.Sketch;
import root.stuff.scores.ScoreHelper;

public class EndScreen extends Screen {
	int start;
	int score;
	
	int scoreX = 40;

	public EndScreen(Sketch sketch, int score) {
		super(sketch);
		start = sketch.millis();
		this.score = score;
	}

	@Override
	public void draw() {
		
	}

	@Override
	public void update() {
		// if ( sketch.millis() - start > (2 * 1000) ) {
			
		// }
	}

	@Override
	public void hud() {
		sketch.background(47, 153, 236);
		sketch.textSize(30);
		sketch.fill(0);
		sketch.text("You died with a score of " + score, 400, 240);
		sketch.text("Press Any Key to Restart", 400, 280);
		displayScores();
	}

	void displayScores() {
		ArrayList<Integer> scores = ScoreHelper.getScores();
		Collections.reverse(scores);
		sketch.text("Recent Scores", 120, 20);
		sketch.textSize(15);

		for ( int i = 0; i < scores.size(); i++ ) {
			sketch.text(scores.get(i), scoreX, 50 + i*18);
		
			if(i < 32) {
				scoreX = 80;
			}
			
			if(i > 32 && i < 64) {
				scoreX = 160;
			}
		
		}
		

	}

	@Override
	public void handleKeydown(int keyCode) {
		sketch.screen = new StartScreen(sketch); 
		ScoreHelper.submitScore(score);
	}

	@Override
	public void handleKeyup(int keyCode) {
		
	}
}
