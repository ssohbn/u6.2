package root.stuff.screen.GrassLands;

import root.stuff.screen.templates.TemplateRow;
import root.stuff.util.Position;

public class GrassLandsRow extends TemplateRow {

	public GrassLandsRow(int y) {
		super(y);
		System.out.println("GrassLandsRow: " + y);
	}

	@Override
	protected void genTiles(int y) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new GrassLandsTile(new Position(i * 64, y));
		}
	}
}
