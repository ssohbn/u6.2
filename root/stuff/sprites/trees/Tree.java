package root.stuff.sprites.trees;

import root.Sketch;
import root.stuff.sprites.Sprite;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class Tree extends Sprite {

	/**
	 * a 64x64 tree sprite
	 * @param position
	 * @param size
	 * @param sketch
	 */
	public Tree(Position position, Sketch sketch) {
		super(position, sketch, new Size(64, 64));
		this.image = sketch.loadImage("./root/resources/blobtree.png");
		this.image.resize(64, 64);
	}
}
