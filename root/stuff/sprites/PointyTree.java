package root.stuff.sprites;

import root.Sketch;
import root.stuff.util.Position;

public class PointyTree extends Tree {
	public PointyTree(Position position, Sketch sketch) {
		super(position, sketch);
		this.image = sketch.loadImage("./root/resources/pointytree.png"); //TODO: i hope this works i had trouble with paths last time
		this.image.resize(64, 64);
	}
}
