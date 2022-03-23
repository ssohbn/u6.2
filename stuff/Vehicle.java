package stuff;
import processing.core.PApplet;

public class Vehicle {
    private Position position;
    private Size size;
    private Color color;
    
    public Vehicle(int x, int y) {
        this.position = new Position(x, y);
        this.size = new Size(10, 10);
        this.color = new Color(255, 0, 0);
    }
    
    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }
    /**
     * dis empty haha
     */
    public void move(){

    };
    
    public void draw(PApplet sketch) {
        sketch.pushMatrix();
        sketch.fill(this.color.r, this.color.g, this.color.b, 255);
        sketch.rect(this.position.x, this.position.y, this.size.width, this.size.height);
        sketch.popMatrix();
    }

}
