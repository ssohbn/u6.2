package root.stuff.tiles.Desert;

import java.util.Random;

import root.Sketch;
import root.stuff.sprites.trees.Cactus;
import root.stuff.sprites.trees.PalmTree;
import root.stuff.tiles.templates.TemplateRow;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class DesertRow extends TemplateRow {

	@Override
	protected void genTiles(int y, Sketch sketch) {
		Random rand = new Random();
		for (int i = 0; i < this.tiles.length; i++) {
			Position position = new Position(i * 64, y);
			int randomNum = rand.nextInt(8);
			if (randomNum == 1) {
				tiles[i] = new DesertTileObstacle(position, sketch, new Cactus(position, sketch));
			} else if (randomNum == 2) {
				tiles[i] = new DesertTileObstacle(position, sketch, new PalmTree(position, sketch));
			} else {
				tiles[i] = new DesertTile(new Position(i * 64, y), sketch);
			}
		}
	}

	public DesertRow(int y, Sketch sketch) {
		super(y, sketch);
	}

	@Override
	public Size getSize() {
		return this.size;
	}
}