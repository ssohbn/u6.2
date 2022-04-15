package root.stuff.screen.GrassLands;

import root.stuff.screen.templates.TemplateRow;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class GrassLandsRow extends TemplateRow {

	public GrassLandsRow(int y) {
		super(y);
	}

	@Override
	protected void genTiles(int y) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new GrassLandsTile(new Position(i * 64, y));
		}
	}

}
