package root;
import processing.core.PApplet;
import root.stuff.interfaces.IView;
import root.stuff.screen.StartScreen;

public class Sketch extends PApplet {

	public static IView screen = new StartScreen();

  public void settings() {
    size(640, 640);
  }

  public void setup() {
    background(255);
  }
  
  public void keyPressed() {
	  Sketch.screen.handleKeydown(this, keyCode);
  }

  public void keyReleased() {
	  Sketch.screen.handleKeyup(this, keyCode);
  }


  public void draw() {
	screen.update(this);
    background(255);
    fill(255);
	Sketch.screen.draw(this);


	Sketch.screen.hud(this);
  }
}