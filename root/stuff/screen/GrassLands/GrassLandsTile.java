package root.stuff.screen.GrassLands;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateTile;
import root.stuff.util.Position;

public class GrassLandsTile extends TemplateTile {

	public GrassLandsTile(Position position) {
		super(position);
		System.out.println("GrassLandsTile: " + position.x + " " + position.y);
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.fill(0, 180, 0);
		super.draw(sketch);
	}
}
	
