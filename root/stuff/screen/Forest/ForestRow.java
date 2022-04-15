package root.stuff.screen.Forest;
import java.rmi.server.Skeleton;
import java.util.Random;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateRow;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class ForestRow extends TemplateRow {

	@Override
	protected void genTiles(int y, PApplet sketch) {
		Random rand = new Random();
		for (int i = 0; i < this.tiles.length; i++) {

			// generate a random number between 1 and 3
			int randomNum = rand.nextInt((3 - 1) + 1) + 1;
			if (randomNum == 1) {
				tiles[i] = new ForestTileTree(new Position(i * 64, y), sketch);
			} else {
				tiles[i] = new ForestTile(new Position(i * 64, y), sketch);
			}
			// thank you copilot

		}
	}

	public ForestRow(int y, PApplet sketch) {
		super(y, sketch);
		//TODO Auto-generated constructor stub
	}

	@Override
	public Size getSize() {
		return this.size;
	}
}