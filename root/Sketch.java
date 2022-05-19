package root;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import root.stuff.screen.Screen;
import root.stuff.screen.StartScreen;
import root.stuff.util.Size;

public class Sketch extends PApplet {

	public PFont arcade;
	public PFont score;
	public PImage CAR1;
	public PImage CAR2;
	public PImage CAR3;
	public PImage HELI;

	public Screen screen = new StartScreen(this);
	public static final Size SCREEN_SIZE = new Size(640, 640);

	public void settings() {
		size(640, 640);
		this.width  = 640;
		this.height = 640;
	}

	public void setup() {
		background(255);
		arcade = createFont("./root/resources/arcade.TTF", 128);
		score = createFont("./root/resources/score.otf", 128);

		CAR1 = loadImage("./root/resources/CAR1.png");
		CAR2 = loadImage("./root/resources/CAR2.png");
		CAR3 = loadImage("./root/resources/CAR3.png");
		HELI = loadImage("./root/resources/HELI.png");


		textFont(arcade);
	}
  
	public void keyPressed() {
		screen.handleKeydown(keyCode);
	}

	public void keyReleased() {
		screen.handleKeyup(keyCode);
	}


  public void draw() {
	screen.update();
	background(255);
	fill(255);
	screen.draw();


	screen.hud();
  }
}