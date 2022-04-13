package root.stuff.vehicles;

import root.stuff.util.Color;
import root.stuff.util.Position;

public class Player extends Car {

	public Player(Position pos) {
		super(pos);
		this.color = new Color(255, 255, 255);
	}
	
}
