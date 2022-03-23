import processing.core.PApplet;
import stuff.Vehicle;

public class Sketch extends PApplet {

  Vehicle v = new Vehicle(0, 0);

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(0);
  }

  public void draw() {
    fill(255);

    v.draw(this);
  }
}