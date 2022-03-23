package stuff.vehicles;

import processing.core.PApplet;
import stuff.Vehicle;
import stuff.util.Color;
import stuff.util.Size;
import stuff.util.Speed;

public class Car extends Vehicle {

    public Car(int x, int y) {
        super(x, y);
        System.out.println(this.position.x);

        this.color = new Color(255, 0, 0);
        this.size = new Size(80, 50);
        this.speed = new Speed(10, 0);
    }

    @Override
    public void move() {
        this.position.x += this.speed.x;
    }
    @Override
    public void draw(PApplet sketch) {
        sketch.pushMatrix();
        sketch.fill(this.color.r, this.color.g, this.color.b, 255);
        sketch.rect(this.position.x, this.position.y, this.size.width, this.size.height);
        sketch.popMatrix();   
    }
    
}
