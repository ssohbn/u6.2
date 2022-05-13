package root.stuff.sprites.vehicles;

import root.Sketch;
import root.stuff.sprites.Sprite;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class Player extends Sprite {

	public Player(Position position, Sketch sketch, Size size) {
		super(position, sketch, size);
		this.image = sketch.loadImage("./root/resources/player.png"); 
		this.image.resize(64, 64);
	}
	
}
