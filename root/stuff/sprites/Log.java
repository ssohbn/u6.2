package root.stuff.sprites;

import root.Sketch;
import root.stuff.util.Position;
import root.stuff.util.Size;
import root.stuff.util.Speed;

public class Log extends Sprite {
	Speed speed;
	/**
	 * creates and adds a log to collideables and drawables
	 * @param position
	 * @param sketch
	 * @param size
	 * @param speed
	 */
	public Log(Position position, Sketch sketch, Size size, Speed speed) {
		super(position, sketch, size, sketch.loadImage("./root/resources/log.png"));
		this.speed = speed;

		sketch.screen.collidables.add(this);
		sketch.screen.drawables.add(this);
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
		this.position.add(this.speed);
	}
	
}