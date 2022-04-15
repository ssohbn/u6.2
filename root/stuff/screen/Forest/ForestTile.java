package root.stuff.screen.Forest;

import processing.core.PApplet;
import root.stuff.screen.templates.TemplateTile;
import root.stuff.util.Position;

public class ForestTile	extends TemplateTile {

	public ForestTile(Position position) {
		super(position);
		//TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet sketch) {
		sketch.fill(50, 180, 50);
		super.draw(sketch);
	}

}
