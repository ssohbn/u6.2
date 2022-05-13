package root.stuff.sprites;

import root.Sketch;
import root.stuff.util.Position;
import root.stuff.util.Size;

public class Log extends Sprite {
	public Log(Position position, Sketch sketch, Size size) {
		super(position, sketch, size, sketch.loadImage("./root/resources/log.png"));
	}

	boolean bob = true; 
	/** cute lil bob for the floaty log */
	private void bob() {
		if ( this.bob ) {
			this.position.y +=2;
		} else {
			this.position.y -=2;
		}
		this.bob = !this.bob;
	}

	@Override
	public void fall(int i) {
		super.fall(i);
		this.bob();
	}
	
}