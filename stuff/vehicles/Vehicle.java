package stuff.vehicles;
import processing.core.PApplet;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Size;
import stuff.util.Speed;
/**
 * abstract vehicle class
 */
public abstract class Vehicle {
    protected Position position;
    protected Size size;
    protected Color color;
    protected Speed speed;

    /**
     * move da vehicle
     */
    public abstract void move();
    
    /**
     * draw da vehicle
     * @param sketch the PApplet instance to draw this vehicle on
     */
    public abstract void draw(PApplet sketch);


}
