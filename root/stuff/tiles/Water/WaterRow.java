package root.stuff.tiles.Water;

import processing.core.PApplet;
import root.Sketch;
import root.stuff.tiles.templates.TemplateRow;
import root.stuff.util.Position;

public class WaterRow extends TemplateRow {

	public WaterRow(int y, Sketch sketch) {
		super(y, sketch);
	}

	@Override
	protected void genTiles(int y, Sketch sketch) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new WaterTile(new Position(i * 64, y), sketch);
		}
	}

}