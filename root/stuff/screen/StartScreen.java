package root.stuff.screen;

import processing.core.PFont;
import root.Sketch;


public class StartScreen extends Screen {
	
	@Override
	public void draw() {

	}

	@Override
	public void update() {
		
	}

	@Override
	public void hud() {
		
		sketch.background(0);
		sketch.fill(0, 255, 0);
		sketch.textSize(50);
		sketch.text("Press Any Key to Start", 320, 320);
		sketch.textAlign(sketch.CENTER, sketch.TOP);
	}

	@Override
	public void handleKeydown(int keyCode) {
		sketch.screen = new PlayScreen(sketch); 
	}

	@Override
	public void handleKeyup(int keyCode) {
		
	}

	public StartScreen(Sketch sketch) {
		super(sketch);
	
	}
}
