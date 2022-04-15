package root.stuff.vehicles;

import processing.core.PApplet;
import root.stuff.util.Color;
import root.stuff.util.Position;

public class Player extends Car {

	public Player(Position pos, PApplet sketch) {
		super(pos, sketch);
		this.color = new Color(255, 255, 255);
	}
	
}
