package root.stuff.sprites;

import processing.core.PApplet;
import processing.core.PImage;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.util.Position;
import root.stuff.util.Size;

public abstract class Sprite implements IDraw, ICollide {
	protected Position position;
	protected Size size;
	protected PImage image;

	public Sprite(Position position, Size size) {
		this.position = position;
		this.size = size;
	}

	@Override
	public Size getSize() {
		return this.size;
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.image(this.image, this.position.x, this.position.y);

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void fall(int i) {
		this.position.y += i;
	}

	@Override
	public void onCollide(ICollide collider) {
		// TODO Auto-generated method stub
	}


}