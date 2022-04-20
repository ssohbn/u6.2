package root.stuff.screen;

import java.util.ArrayList;

import processing.core.PApplet;
import root.Sketch;
import root.stuff.interfaces.IDraw;
import root.stuff.interfaces.IRow;
import root.stuff.sprites.vehicles.Car;
import root.stuff.sprites.vehicles.Player;
import root.stuff.tiles.Biome;
import root.stuff.tiles.Forest.ForestRow;
import root.stuff.tiles.GrassLands.GrassLandsRow;
import root.stuff.tiles.Water.WaterRow;
import root.stuff.util.Color;
import root.stuff.util.Position;
import root.stuff.util.Speed;

public class PlayScreen extends Screen {

	public static int score = 0;
	Player player;
	Car  towMater, sallyCarrera;
	Biome biome;
	boolean[] keys = new boolean[4];
	final int kLEFT 	= 0;
	final int kRIGHT  = 1;
	final int kUP 	= 2;
	final int kDOWN 	= 3;
	boolean firstFlag = false;
	public ArrayList<IDraw> drawables = genStartingRows();


	public PlayScreen(Sketch sketch) {
		super(sketch);
		this.player = new Player(new Position(320, 320), sketch);
		drawables.add(player);

		this.towMater 	  = new Car(new Position(300, 50), new Color(80, 20, 40), sketch);
		drawables.add(towMater);

		this.sallyCarrera = new Car(new Position(200, 50), new Color(0, 0, 255), sketch);
		drawables.add(sallyCarrera);
		this.biome = Biome.FOREST;
	}



	public ArrayList<IDraw> genStartingRows() {
		ArrayList<IDraw> rows = new ArrayList<IDraw>();
		for (int i = 0; i < 10; i++) {
			rows.add(new GrassLandsRow(i * 64, sketch) );
		}
		rows.add(new GrassLandsRow(-64, sketch));
		return rows;
	}

	@Override
	public void draw() {
		for (IDraw drawable : drawables) {
			drawable.draw();
		}

		player.draw();
		sallyCarrera.draw();
		towMater.draw();
	}

	@Override
	public void update() {
		score++;
		
		inputMove(player);
		sallyCarrera.move();
		towMater.move();
		boolean shouldGenNewRow = false;
		ArrayList<IDraw> toRemove = new ArrayList<IDraw>();

		for (IDraw drawable : drawables) {
			drawable.fall(2);

			if (drawable.shouldPurgeOffscreen() ) {
				toRemove.add(drawable);

				if (drawable instanceof IRow) {
					shouldGenNewRow = true;
				}
			}
		}

		if (shouldGenNewRow) {
			genNewRow();
		}

		for ( IDraw drawable : toRemove) {
			System.out.println("Removing " + drawable);
			drawables.remove(drawable);
			System.out.println(drawables.size());
		}
	}

	public void genNewRow() {
		switch (this.biome) {
			case GRASSLANDS:
				drawables.add(new GrassLandsRow(-64, sketch));
				break;
			case DESERT:
				break;
			case FOREST:
				drawables.add(new ForestRow(-64, sketch));
				break;
			case OCEAN:
				drawables.add(new WaterRow(-64, sketch));
				break;
			default:
				break;
		}

	}

	@Override
	public void hud() {
		sketch.fill(0);
		sketch.text("cool hud", 40, 240);
		sketch.text("score: " + score, 40, 260);

		
	}

	public void inputMove(Car car) {
		// this leaves the awesome INTENDED FEATURE 
		// where moving diagonally is faster
		// if (keys[kLEFT]) this.lmq.move(new Speed(-64, 0));
		// if (keys[kRIGHT]) this.lmq.move(new Speed(64, 0));
		// if (keys[kDOWN]) this.lmq.move(new Speed(0, 64));
		// if (keys[kUP]) this.lmq.move(new Speed(0, -64));

	}

	@Override
	public void handleKeydown(int keyCode) {
		if (keyCode == sketch.LEFT) {
			keys[kLEFT] = true;
			this.player.move(new Speed(-64, 0));
		}

		if (keyCode == sketch.UP) {
			this.player.move(new Speed(0, -64));
			keys[kUP] = true;
		}

		if (keyCode == sketch.RIGHT) {
			keys[kRIGHT] = true;
			this.player.move(new Speed(64, 0));
		}

		if (keyCode == sketch.DOWN) {
			keys[kDOWN] = true;
			this.player.move(new Speed(0, 64));
		}
	}

	@Override
	public void handleKeyup(int keyCode) {
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