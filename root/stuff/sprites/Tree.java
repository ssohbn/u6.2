package root.stuff.sprites;

import processing.core.PApplet;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class Tree extends Sprite {

	/**
	 * a 64x64 tree sprite
	 * @param position
	 * @param size
	 * @param sketch
	 */
	public Tree(Position position, PApplet sketch) {
		super(position, new Size(64, 64), sketch);
		this.image = sketch.loadImage("./root/resources/blobtree.png"); //TODO: i hope this works i had trouble with paths last time
		this.image.resize(64, 64);
	}
}
