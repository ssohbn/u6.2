package stuff.screen;

import java.util.ArrayList;

import processing.core.PApplet;
import stuff.interfaces.IView;
import stuff.util.Color;
import stuff.util.Position;
import stuff.util.Speed;
import stuff.vehicles.Car;

public class PlayScreen implements IView {
	public static ArrayList<Row> rows;

  Car lmq = new Car(new Position(50, 50), new Color(255, 0, 0));
  Car towMater = new Car(new Position(300, 50), new Color(80, 20, 40));
  Car sallyCarrera = new Car(new Position(200, 50), new Color(0, 0, 255));
  boolean[] keys = new boolean[4];
  final int kLEFT = 0;
  final int kRIGHT = 1;
  final int kUP = 2;
  final int kDOWN = 3;

	@Override
	public void draw(PApplet sketch) {
		for (Row row : rows) {
			row.draw(sketch);
		}

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
		// TODO Auto-generated method stub
		
	}

	public void inputMove(Car car) {
		// this leaves the awesome INTENDED FEATURE 
		// where moving diagonally is faster
		if (keys[kLEFT]) lmq.move(new Speed(-5, 0));
		if (keys[kRIGHT]) lmq.move(new Speed(5, 0));
		if (keys[kDOWN]) lmq.move(new Speed(0, 5));
		if (keys[kUP]) lmq.move(new Speed(0, -5));

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