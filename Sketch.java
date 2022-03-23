import processing.core.PApplet;
import stuff.util.Position;
import stuff.util.Speed;
import stuff.vehicles.Car;

public class Sketch extends PApplet {

  Car lmq = new Car(new Position(10,10));
  Car player = new Car(new Position(50, 50));

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(255);
  }

  public void keyPressed() {
    if ( key != CODED) return;
    System.out.println(key);

    // left
    if ( keyCode == 37) {
      player.position.add(new Speed(-5, 0));
    }
      
    // up
    if ( keyCode == 38) {
      player.position.add(new Speed(0, -5));
    }

    // right
    if ( keyCode == 39) {
      player.position.add(new Speed(5, 0));
    }

    // down
    if ( keyCode == 40) {
      player.position.add(new Speed(0, 5));
    }

  }

  public void draw() {
    background(255);

    fill(255);

    lmq.draw(this);
    lmq.move();

    player.draw(this);
  }
}