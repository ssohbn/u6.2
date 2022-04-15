package root.stuff.tiles.GrassLands;

import processing.core.PImage;
import root.Sketch;
import root.stuff.tiles.templates.TemplateTile;
import root.stuff.util.Position;

public class GrassLandsTile extends TemplateTile {
	private PImage grass;

	public GrassLandsTile(Position position, Sketch sketch) {
		super(position, sketch);

		this.grass = sketch.loadImage("./root/resources/grass.png"); //TODO: i hope this works i had trouble with paths last time
		this.grass.resize(64, 64);
	}

	@Override
	public void draw() {
		sketch.fill(30, 180, 30);
		super.draw();
		sketch.image(grass, position.x, position.y);
	}
}
	
