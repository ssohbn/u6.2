package root.stuff.sprites.vehicles;

import processing.core.PImage;
import root.Sketch;
import root.stuff.util.Color;
import root.stuff.util.Position;

public class Player extends Car {
	PImage image;
	

	public Player(Position pos, Sketch sketch) {
		super(pos, sketch);
		this.color = new Color(255, 255, 255);
		this.image = sketch.loadImage("./root/resources/player.png");
	}

	@Override
	public void draw() {
		this.sketch.image(this.image, this.position.x, this.position.y);
	}
	
}
