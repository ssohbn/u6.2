package root.stuff.interfaces;

import processing.core.PApplet;

public interface IRow extends IDraw {
	public ITile[] getTiles();

	public void fall(int i);

}