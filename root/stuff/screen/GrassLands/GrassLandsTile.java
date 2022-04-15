package root.stuff.screen.GrassLands;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateTile;
import root.stuff.util.Position;

public class GrassLandsTile extends TemplateTile {

	public GrassLandsTile(Position position, PApplet sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		sketch.fill(0, 180, 0);
		super.draw();
	}
}
	
