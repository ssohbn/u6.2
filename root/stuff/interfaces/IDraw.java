package root.stuff.interfaces;

import processing.core.PApplet;
import root.stuff.util.Position;
import root.stuff.util.Size;

public interface IDraw {
	public void draw(PApplet sketch);
	public Position getPosition();
	public Size getSize();
	public void fall(int i);

	default boolean shouldPurgeOffscreen() {
		boolean res = false;
		if (this.getPosition().y >= 640) {
			res = true;
		}
		if (this.getPosition().x > 640 || this.getPosition().x < 0) {
			res = true;
		}

		return res;
	}
}