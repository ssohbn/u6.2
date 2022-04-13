package root.stuff.screen.Water;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateTile;
import root.stuff.util.Position;

public class WaterTile extends TemplateTile {

	public WaterTile(Position position) {
		super(position);
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.fill(0, 0, 180);
		super.draw(sketch);
	}
}