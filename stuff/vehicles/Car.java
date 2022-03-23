package stuff.vehicles;

import processing.core.PApplet;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Size;
import stuff.util.Speed;

public class Car extends Vehicle {
    /**
     * simple vehicle
     * it go vroom :)
     * @param pos starting position of da vroom vroom car
     */
    public Car(Position pos) {
        this.position = pos;
        this.color = new Color(255, 0, 0);
        this.size  = new Size(80, 50);
        this.speed = new Speed(10, 0);
    }
    /**
     * colorful vroom vroom
     * @param pos
     * @param color
     */
    public Car(Position pos, Color color) {
        this.position = pos;
        this.color = color;
        this.size  = new Size(80, 50);
        this.speed = new Speed(10, 0);
    }

    @Override
    public void move() {
        this.position.add(this.speed);
    }

    public void move(Speed speed) {
        this.position.add(speed); 
    }

    @Override
    public void draw(PApplet sketch) {
        int wheelSize = 20;

        sketch.pushMatrix();
        sketch.fill(this.color.r, this.color.g, this.color.b, 255);
        sketch.rect(this.position.x, this.position.y, this.size.width, this.size.height);

        sketch.fill(0);
        // left block wheel
        sketch.rect(this.position.x, this.position.y + this.size.height, wheelSize, wheelSize);
        // right block wheel
        sketch.rect(this.position.x + this.size.width - wheelSize, this.position.y + this.size.height, wheelSize, wheelSize);

        sketch.popMatrix();   
    }
}
