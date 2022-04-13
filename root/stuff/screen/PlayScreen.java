package root.stuff.screen;

import java.util.ArrayList;

import processing.core.PApplet;
import root.Sketch;
import root.stuff.interfaces.IView;
import root.stuff.util.Color;
import root.stuff.util.Position;
import root.stuff.util.Speed;
import root.stuff.vehicles.Car;

public class PlayScreen implements IView {
	Car lmq, towMater, sallyCarrera;
	public PlayScreen() {
		this.lmq = new Car(new Position(50, 50), new Color(255, 0, 0));
		this.towMater = new Car(new Position(300, 50), new Color(80, 20, 40));
		this.sallyCarrera = new Car(new Position(200, 50), new Color(0, 0, 255));

	}

	public static ArrayList<Row> rows;

  boolean[] keys = new boolean[4];
  final int kLEFT = 0;
  final int kRIGHT = 1;
  final int kUP = 2;
  final int kDOWN = 3;

	@Override
	public void draw(PApplet sketch) {
		// for (Row row : rows) {
		// 	row.draw(sketch);
		// }

		lmq.draw(sketch);
		sallyCarrera.draw(sketch);
		towMater.draw(sketch);
		
	}

	@Override
	public void update(PApplet sketch) {
		
		inputMove(lmq);
		sallyCarrera.move();
		towMater.move();
	}

	@Override
	public void hud(PApplet sketch) {
		sketch.fill(0);
		sketch.text("cool hud", 40, 240);

		
	}

	public void inputMove(Car car) {
		// this leaves the awesome INTENDED FEATURE 
		// where moving diagonally is faster
		if (keys[kLEFT]) this.lmq.move(new Speed(-5, 0));
		if (keys[kRIGHT]) this.lmq.move(new Speed(5, 0));
		if (keys[kDOWN]) this.lmq.move(new Speed(0, 5));
		if (keys[kUP]) this.lmq.move(new Speed(0, -5));

	}

	@Override
	public void handleKeydown(PApplet sketch, int keyCode) {
		if (keyCode == sketch.LEFT)
		keys[kLEFT] = true;
		if (keyCode == sketch.UP)  
		keys[kUP] = true;
		if (keyCode == sketch.RIGHT)
		keys[kRIGHT] = true;
		if (keyCode == sketch.DOWN)
		keys[kDOWN] = true;
	}

	@Override
	public void handleKeyup(PApplet sketch, int keyCode) {
		// TODO Auto-generated method stub
		
		if (keyCode == sketch.LEFT)
		keys[kLEFT] = false;
		if (keyCode == sketch.UP)  
		keys[kUP] = false;
		if (keyCode == sketch.RIGHT)
		keys[kRIGHT] = false;
		if (keyCode == sketch.DOWN)
		keys[kDOWN] = false;
		}

	
}