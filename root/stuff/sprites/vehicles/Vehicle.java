package root.stuff.sprites.vehicles;
import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.interfaces.IMove;
import root.stuff.sprites.Sprite;
import root.stuff.util.Color;
import root.stuff.util.Position;
import root.stuff.util.Size;
import root.stuff.util.Speed;
/**
 * abstract vehicle class
 */
public abstract class Vehicle extends Sprite implements IDraw, ICollide, IMove {
    protected Position position;
    protected Size size;
    protected Color color;
    protected Speed speed;
	protected Sketch sketch;

	public Vehicle(Position position, Sketch sketch) {
		super(position, sketch, new Size(64, 64));
		this.position = position;
		this.sketch = sketch;
	}

	public void fall(int y) {
		this.position.y += y;
	}

    /**
     * move da vehicle
     */
    public abstract void move();
    
    /**
     * draw da vehicle
     */
    public abstract void draw();
}
