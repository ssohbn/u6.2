package root.stuff.interfaces;

import root.stuff.util.Position;
import root.stuff.util.Size;

public interface IDraw {
	/** defines how we interact and draw drawable object */
	public void draw();
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