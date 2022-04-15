package root.stuff.tiles.Forest;

import processing.core.PApplet;
import root.Sketch;
import root.stuff.tiles.templates.TemplateTile;
import root.stuff.util.Position;

public class ForestTile	extends TemplateTile {

	public ForestTile(Position position, Sketch sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		this.sketch.fill(50, 180, 50);
		super.draw();
	}

}
