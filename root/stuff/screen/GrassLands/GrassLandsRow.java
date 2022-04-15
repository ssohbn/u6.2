package root.stuff.screen.GrassLands;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateRow;
import root.stuff.util.Position;

public class GrassLandsRow extends TemplateRow {

	public GrassLandsRow(int y, PApplet sketch) {
		super(y, sketch);
	}

	@Override
	protected void genTiles(int y, PApplet sketch) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new GrassLandsTile(new Position(i * 64, y), sketch);
		}
	}

}
