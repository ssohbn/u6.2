package root.stuff.sprites.trees;

import root.Sketch;
import root.stuff.util.Position;

public class DeadTree extends Tree {

	public DeadTree(Position position, Sketch sketch) {
		super(position, sketch);
		this.image = sketch.loadImage("./root/resources/deadtree.png"); //TODO: i hope this works i had trouble with paths last time
		this.image.resize(64, 64);
	}
}
