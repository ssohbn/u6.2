package root.stuff.tiles.Desert;

import processing.core.PImage;
import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.sprites.trees.Tree;
import root.stuff.util.Position;

public class DesertTileObstacle extends DesertTile implements ICollide {
	Tree thing;
	PImage image;
	public DesertTileObstacle(Position position, Sketch sketch, Tree tree) {
		super(position, sketch);
		this.thing = tree;
	}

	@Override
	public void draw() {
		super.draw();
		thing.draw(); // woohoo i should have a tree now
	}

	@Override
	public boolean colliding(ICollide collider) {
		return this.thing.posInBounds(collider);
	}

	@Override
	public void onCollide(ICollide collider) {
		// nothing special
	}
	
}
