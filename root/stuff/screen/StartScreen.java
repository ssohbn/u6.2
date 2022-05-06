package root.stuff.screen;

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
		sketch.fill(0);
		sketch.text("welcome to videogame click any key", 40, 240);
		
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
