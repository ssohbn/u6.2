package root.stuff.tiles.templates;

import root.Sketch;
import root.stuff.interfaces.IRow;
import root.stuff.interfaces.ITile;
import root.stuff.util.Position;
import root.stuff.util.Size;

public abstract class TemplateRow implements IRow {
	protected Size size;
	protected Position position;
	protected ITile[] tiles;
	protected Sketch sketch;
	public TemplateRow(int y, Sketch sketch) {
		this.position = new Position(0, y); // start at top left always 
		this.size = new Size(640, y);
		this.tiles = new ITile[10];
		this.sketch = sketch;
		genTiles(y, sketch);
	}

	protected abstract void genTiles(int y, Sketch sketch);

	public Size getSize() {
		return this.size;
	}

	@Override
	public void draw() {
		for (ITile tile : this.tiles) {
			tile.draw();
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
