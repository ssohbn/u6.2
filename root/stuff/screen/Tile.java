package root.stuff.screen;

import processing.core.PApplet;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.util.Color;
import root.stuff.util.Position;
import root.stuff.util.Size;

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