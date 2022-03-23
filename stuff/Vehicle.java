package stuff;
import processing.core.PApplet;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Size;
import stuff.util.Speed;

public abstract class Vehicle {
    public Position position;
    public Size size;
    public Color color;
    public Speed speed;
    
    public Vehicle(int x, int y) {
        this.position = new Position(x, y);
    }

    /**
     * dis empty haha
     */
    public void move(){

    };
    
    public void draw(PApplet sketch) {

    }

}
