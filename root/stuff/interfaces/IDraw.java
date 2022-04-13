package root.stuff.interfaces;

import processing.core.PApplet;
import root.stuff.util.Position;

public interface IDraw {
	public void draw(PApplet sketch);
	public Position getPosition();
	public void fall(int i);

	default boolean shouldPurgeOffscreen() {
		boolean res = false;
		if (this.getPosition().y > 640) {
			res = true;
		}

		return res;
	}
}