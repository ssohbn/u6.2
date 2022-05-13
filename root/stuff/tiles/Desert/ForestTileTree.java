package root.stuff.tiles.Forest;

import processing.core.PImage;
import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.sprites.trees.Tree;
import root.stuff.util.Position;

public class ForestTileTree extends ForestTile implements ICollide {
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

	@Override
	public boolean colliding(ICollide collider) {
		return this.tree.posInBounds(collider);
	}

	@Override
	public void onCollide(ICollide collider) {
		// nothing special
	}
	
}
