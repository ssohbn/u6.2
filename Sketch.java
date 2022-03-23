import processing.core.PApplet;
import stuff.Vehicle;
import stuff.vehicles.Car;

public class Sketch extends PApplet {

  Car c = new Car(10,10);

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(0);
  }

  public void draw() {
    fill(255);

    c.draw(this);
  }
}