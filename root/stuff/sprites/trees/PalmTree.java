package root.stuff.sprites.trees;

import root.Sketch;
import root.stuff.util.Position;

public class PalmTree extends Tree {

	public PalmTree(Position position, Sketch sketch) {
		super(position, sketch);
		this.image = sketch.loadImage("./root/resources/palmtree.png");
		this.image.resize(64, 64);

	}
	
}
