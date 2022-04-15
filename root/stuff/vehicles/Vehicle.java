package root.stuff.vehicles;
import processing.core.PApplet;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.util.Color;
import root.stuff.util.Position;
import root.stuff.util.Size;
import root.stuff.util.Speed;
/**
 * abstract vehicle class
 */
public abstract class Vehicle implements IDraw, ICollide {
    protected Position position;
    protected Size size;
    protected Color color;
    protected Speed speed;
	protected PApplet sketch;

	public void fall(int y) {
		this.position.y += y;
	}

    /**
     * move da vehicle
     */
    public abstract void move();
    
    /**
     * draw da vehicle
     * @param sketch the PApplet instance to draw this vehicle on
     */
    public abstract void draw();
}
