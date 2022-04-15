package root.stuff.tiles.Forest;

import processing.core.PImage;
import root.Sketch;
import root.stuff.sprites.Tree;
import root.stuff.util.Position;

public class ForestTileTree extends ForestTile {
	Tree tree;
	PImage image;
	public ForestTileTree(Position position, Sketch sketch, Tree tree) {
		super(position, sketch);
		this.tree = tree;
	}

	@Override
	public void draw() {
		super.draw();
		tree.draw(); // woohoo i should have a tree now
	}
	
}
