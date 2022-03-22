import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(0);
  }

  public void draw() {
    fill(255);
    ellipse(mouseX, mouseY, 25, 25);
  }
}