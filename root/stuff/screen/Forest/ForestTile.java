package root.stuff.screen.Forest;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateTile;
import root.stuff.util.Position;

public class ForestTile	extends TemplateTile {

	public ForestTile(Position position, PApplet sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		this.sketch.fill(50, 180, 50);
		super.draw();
	}

}
