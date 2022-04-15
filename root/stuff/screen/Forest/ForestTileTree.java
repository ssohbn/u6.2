package root.stuff.screen.Forest;

import root.Sketch;
import root.stuff.sprites.Tree;
import root.stuff.util.Position;

public class ForestTileTree extends ForestTile {
	Tree tree = new Tree(this.position, this.sketch);
	public ForestTileTree(Position position, Sketch sketch) {
		super(position, sketch);
	}

	@Override
	public void draw() {
		super.draw();
		tree.draw(); // woohoo i should have a tree now
	}
	
}
