import processing.core.PApplet;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Speed;
import stuff.vehicles.Car;

public class Sketch extends PApplet {

  Car lmq = new Car(new Position(50, 50), new Color(255, 0, 0));
  Car towMater = new Car(new Position(300, 50), new Color(80, 20, 40));
  Car sallyCarrera = new Car(new Position(200, 50), new Color(0, 0, 255));
  boolean[] keys = new boolean[4];
  final int kLEFT = 0;
  final int kRIGHT = 1;
  final int kUP = 2;
  final int kDOWN = 3;

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(255);
  }
  
  public void keyPressed() {
    if (keyCode == LEFT)
      keys[kLEFT] = true;
    if (keyCode == UP)  
      keys[kUP] = true;
    if (keyCode == RIGHT)
      keys[kRIGHT] = true;
    if (keyCode == DOWN)
      keys[kDOWN] = true;
  }

  public void keyReleased() {
    if (keyCode == LEFT)
      keys[kLEFT] = false;
    if (keyCode == UP)  
      keys[kUP] = false;
    if (keyCode == RIGHT)
      keys[kRIGHT] = false;
    if (keyCode == DOWN)
      keys[kDOWN] = false;
  }

  public void inputMove(Car car) {
    // this leaves the awesome INTENDED FEATURE 
    // where moving diagonally is faster
    if (keys[kLEFT]) lmq.move(new Speed(-5, 0));
    if (keys[kRIGHT]) lmq.move(new Speed(5, 0));
    if (keys[kDOWN]) lmq.move(new Speed(0, 5));
    if (keys[kUP]) lmq.move(new Speed(0, -5));

  }

  public void draw() {
    background(255);
    fill(255);

    lmq.draw(this);
    inputMove(lmq);

    sallyCarrera.draw(this);
    sallyCarrera.move();

    towMater.draw(this);
    towMater.move();
  }
}