package stuff.screen;

import processing.core.PApplet;
import stuff.interfaces.ICollide;
import stuff.interfaces.IDraw;

public abstract class Row implements IDraw, ICollide {
	final Tile[] tiles = new Tile[6]; // 6x6

	@Override
	public void draw(PApplet sketch) {
		for (Tile tile : tiles) {
			tile.draw(sketch);
		}	
	}
}