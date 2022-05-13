package root.stuff.tiles.Water;

import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.tiles.templates.TemplateTile;
import root.stuff.util.Position;

public class WaterTile extends TemplateTile implements ICollide {

	public WaterTile(Position position, Sketch sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		sketch.fill(0, 0, 180);
		super.draw();
	}

	@Override
	public void onCollide(ICollide collider) {
		
	}
}