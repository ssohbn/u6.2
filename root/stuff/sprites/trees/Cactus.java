package root.stuff.sprites.trees;

import root.Sketch;
import root.stuff.util.Position;

public class Cactus extends Tree {

	public Cactus(Position position, Sketch sketch) {
		super(position, sketch);
		this.image = sketch.loadImage("./root/resources/cactus.png");
		this.image.resize(64, 64);
	}
	
}
