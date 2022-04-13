import processing.core.PApplet;
import stuff.interfaces.IView;
import stuff.screen.PlayScreen;
import stuff.screen.StartScreen;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Speed;
import stuff.vehicles.Car;

public class Sketch extends PApplet {

	public IView screen = new StartScreen();


  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(255);
  }
  
  public void keyPressed() {
	  screen.handleKeydown(this, keyCode);
  }

  public void keyReleased() {
	  screen.handleKeyup(this, keyCode);
  }


  public void draw() {
	screen.update(this);
    background(255);
    fill(255);
	screen.draw(this);


	screen.hud(this);
  }
}