package root.stuff.screen.templates;

import processing.core.PApplet;
import root.stuff.interfaces.ITile;
import root.stuff.util.Position;
import root.stuff.util.Size;

public abstract class TemplateTile implements ITile {
	protected Position position;
	protected Size size;

	public TemplateTile(Position position) {
		this.position = position;
		this.size = new Size(64, 64);
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.rect(position.x, position.y, size.width, size.height);
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public Size getSize() {
		return this.size;
	}

	public void fall(int y) {
		this.position.y += y;
	}

}
