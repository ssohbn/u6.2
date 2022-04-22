package root.stuff.tiles.GrassLands;

import root.Sketch;
import root.stuff.tiles.templates.TemplateRow;
import root.stuff.util.Position;

public class GrassLandsRow extends TemplateRow {

	public GrassLandsRow(int y, Sketch sketch) {
		super(y, sketch);
	}

	@Override
	protected void genTiles(int y, Sketch sketch) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new GrassLandsTile(new Position(i * 64, y), sketch);
		}
	}

}
