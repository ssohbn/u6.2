package stuff.screen;

import processing.core.PApplet;
import stuff.interfaces.ICollide;
import stuff.interfaces.IDraw;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Size;

public abstract class Tile implements IDraw, ICollide {
	protected Size size;
	protected Position position;
	protected Color color;

	public Tile(Size size, Position position) {
		this.size = size;
		this.position = position;
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.fill(color.r, color.g, color.b, 255);
		sketch.rect(position.x, position.y, size.width, size.height);
	}
}