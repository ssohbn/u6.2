package root.stuff.screen.Water;

import root.stuff.screen.templates.TemplateRow;
import root.stuff.util.Position;

public class WaterRow extends TemplateRow {

	public WaterRow(int y) {
		super(y);
	}

	@Override
	protected void genTiles(int y) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new WaterTile(new Position(i * 64, y));
		}
	}

}