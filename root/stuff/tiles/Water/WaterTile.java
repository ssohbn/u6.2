package root.stuff.tiles.Water;

import processing.core.PApplet;
import root.Sketch;
import root.stuff.tiles.templates.TemplateTile;
import root.stuff.util.Position;

public class WaterTile extends TemplateTile {

	public WaterTile(Position position, Sketch sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		sketch.fill(0, 0, 180);
		super.draw();
	}
}