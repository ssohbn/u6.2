package root.stuff.sprites.vehicles;

import root.Sketch;
import root.stuff.util.Color;
import root.stuff.util.Position;

public class Player extends Car {

	public Player(Position pos, Sketch sketch) {
		super(pos, sketch);
		this.color = new Color(255, 255, 255);
	}
	
}
