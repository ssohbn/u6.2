package root.stuff.tiles.Forest;

import java.util.Random;

import root.Sketch;
import root.stuff.sprites.trees.DeadTree;
import root.stuff.sprites.trees.PointyTree;
import root.stuff.sprites.trees.Tree;
import root.stuff.tiles.templates.TemplateRow;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class ForestRow extends TemplateRow {

	@Override
	protected void genTiles(int y, Sketch sketch) {
		Random rand = new Random();
		for (int i = 0; i < this.tiles.length; i++) {
			Position position = new Position(i * 64, y);
			// generate a random number between 1 and 3
			int randomNum = rand.nextInt((12 - 1) + 1) + 1;
			if (randomNum == 1) {
				tiles[i] = new ForestTileTree(position, sketch, new Tree(position, sketch));
			} else if (randomNum == 2) {
				tiles[i] = new ForestTileTree(position, sketch, new PointyTree(position, sketch));
			} else if (randomNum == 3) {
				tiles[i] = new ForestTileTree(position, sketch, new DeadTree(position, sketch));
			} else {
				tiles[i] = new ForestTile(new Position(i * 64, y), sketch);
			}
		}
	}

	public ForestRow(int y, Sketch sketch) {
		super(y, sketch);
		//TODO Auto-generated constructor stub
	}

	@Override
	public Size getSize() {
		return this.size;
	}
}