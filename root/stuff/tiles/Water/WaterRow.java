package root.stuff.tiles.Water;

import java.util.Random;

import root.Sketch;
import root.stuff.sprites.Log;
import root.stuff.tiles.templates.TemplateRow;
import root.stuff.util.Position;
import root.stuff.util.Size;
import root.stuff.util.Speed;

public class WaterRow extends TemplateRow {
	Log log;

	public WaterRow(int y, Sketch sketch) {
		super(y, sketch);
	}

	@Override
	protected void genTiles(int y, Sketch sketch) {
		for (int i = 0; i < this.tiles.length; i++) {
			tiles[i] = new WaterTile(new Position(i * 64, y), sketch);
		}
		Random r = new Random();
		boolean left = r.nextBoolean();
		Size size = new Size(128, 64);
		if ( left ) {
			this.log = new Log(new Position(0, -64), sketch, size, new Speed(4, 0));
		} else {
			this.log = new Log(new Position(sketch.width, -32), sketch, size, new Speed(-4, 0));
		}
	}
	@Override
	public void draw() {
		super.draw();
		this.log.draw();
	}

	@Override
	public void fall(int y) {
		// TODO Auto-generated method stub
		super.fall(y);
		this.log.fall(y);
	}
}