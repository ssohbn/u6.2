package root.stuff.tiles.Desert;

import root.Sketch;
import root.stuff.tiles.templates.TemplateTile;
import root.stuff.util.Position;

public class DesertTile	extends TemplateTile {

	public DesertTile(Position position, Sketch sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		this.sketch.fill(50, 180, 50);
		super.draw();
	}

}
