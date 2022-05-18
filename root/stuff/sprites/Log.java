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
	}

	@Override
	public void fall(int i) {
		super.fall(i);
		this.position.add(this.speed);
	}
	
}