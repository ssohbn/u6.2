package root.stuff.screen;

import processing.core.PApplet;
import root.Sketch;

public class StartScreen extends Screen {

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hud() {
		sketch.fill(0);
		sketch.text("welcome to videogame click any key", 40, 240);
		
	}

	@Override
	public void handleKeydown(int keyCode) {
		sketch.screen = new PlayScreen(sketch); 
	}

	@Override
	public void handleKeyup(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	public StartScreen(Sketch sketch) {
		super(sketch);

	}

	
}
