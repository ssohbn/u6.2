package root.stuff.screen.templates;

import processing.core.PApplet;
import root.stuff.interfaces.IRow;
import root.stuff.interfaces.ITile;
import root.stuff.util.Position;

public abstract class TemplateRow implements IRow {
	Position position;
	protected ITile[] tiles;
	public TemplateRow(int y) {
		this.position = new Position(0, y); // start at top left always 
		this.tiles = new ITile[10];
		genTiles(y);
	}

	protected void genTiles(int y) {
		for (int i = 0; i < this.tiles.length; i++) {
			// Stuff
		}
	}

	@Override
	public void draw(PApplet sketch) {
		for (ITile tile : this.tiles) {
			tile.draw(sketch);
		}
	}

	public void fall(int y) {
		this.position.y += y;
		for (ITile tile : this.tiles) {
			tile.fall(y);
		}

	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public ITile[] getTiles() {
		return tiles;
	}
}
