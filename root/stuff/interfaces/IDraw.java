package root.stuff.interfaces;

import processing.core.PApplet;
import root.stuff.util.Position;

public interface IDraw {
	public void draw(PApplet sketch);
	public Position getPosition();
}