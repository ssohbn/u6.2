package root.stuff.sprites;

import processing.core.PApplet;
import processing.core.PImage;
import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.util.Position;
import root.stuff.util.Size;

public abstract class Sprite implements IDraw, ICollide {
	protected Position position;
	protected Size size;
	protected PImage image;
	protected PApplet sketch;

	public Sprite(Position position, Sketch sketch) {
		this.position = position;
		this.size = size;
		this.sketch = sketch;
	}

	@Override
	public Size getSize() {
		return this.size;
	}

	@Override
	public void draw() {
		this.sketch.image(this.image, this.position.x, this.position.y);
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