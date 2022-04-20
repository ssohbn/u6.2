package root.stuff.screen;

import java.util.ArrayList;

import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.interfaces.IMove;
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
	boolean[] pkeys = new boolean[4];

	final int kLEFT 	= 0;
	final int kRIGHT  = 1;
	final int kUP 	= 2;
	final int kDOWN 	= 3;
	boolean firstFlag = false;
	public ArrayList<IDraw> drawables = genStartingRows();
	public ArrayList<IMove> moveables = new ArrayList<IMove>();
	public ArrayList<ICollide> collidables = new ArrayList<ICollide>();


	public PlayScreen(Sketch sketch) {
		super(sketch);

		// this is kidna scuffed i think i hope it works :)
		this.player = new Player(new Position(320, 320), sketch);
		drawables.add(player);
		moveables.add(player);

		this.towMater 	  = new Car(new Position(0, 64), new Color(80, 20, 40), sketch);
		drawables.add(towMater);
		moveables.add(towMater);

		this.sallyCarrera = new Car(new Position(0, 128), new Color(0, 0, 255), sketch);
		drawables.add(sallyCarrera);
		moveables.add(sallyCarrera);

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

		for (ICollide collider : collidables) {
			if (player.colliding(collider)) {
				//TODO: die
				System.out.println("player should probably die");
			}
		}


		playerMovementUpdate();
		for (IMove moveable : moveables) {
			moveable.move();
		}

		score++;
		
		boolean shouldGenNewRow = false;
		ArrayList<IDraw> toRemove = new ArrayList<IDraw>();
		ArrayList<ICollide> toRemoveCollidable = new ArrayList<ICollide>();

		for (IDraw drawable : drawables) {

			drawable.fall(2);

			if (drawable.shouldPurgeOffscreen() ) {
				if (drawable instanceof IRow ) {
					toRemove.add(drawable);
					shouldGenNewRow = true;
				}
			}
		}
		
		for ( ICollide collidable : collidables ) {
			if (collidable.shouldPurgeOffscreen() ) {
				toRemoveCollidable.add(collidable);
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

		for ( ICollide collidable : toRemoveCollidable ) {
			System.out.println("Removing " + collidable);
			collidables.remove(collidable);
			System.out.println(collidables.size());
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

	@Override
	public void handleKeydown(int keyCode) {
		if (keyCode == sketch.LEFT) {
			keys[kLEFT] = true;
		} else if (keyCode == sketch.UP) {
			keys[kUP] = true;
		} else if (keyCode == sketch.RIGHT) {
			keys[kRIGHT] = true;
		} else if (keyCode == sketch.DOWN) {
			keys[kDOWN] = true;
		}

		pkeys = keys;
	}

	@Override
	public void handleKeyup(int keyCode) {
		if (keyCode == sketch.LEFT)
			keys[kLEFT] = false;
		if (keyCode == sketch.UP)  
			keys[kUP] = false;
		if (keyCode == sketch.RIGHT)
			keys[kRIGHT] = false;
		if (keyCode == sketch.DOWN)
			keys[kDOWN] = false;
		}

	public void playerMovementUpdate() {
		if (!keys[kLEFT] && !pkeys[kRIGHT] && !keys[kUP] && !pkeys[kDOWN]) {
			this.player.setSpeed(new Speed(0, 0));
		}

		if (pkeys[kLEFT]) {
			this.player.setSpeed(new Speed(-64, 0));
		}

		if (pkeys[kRIGHT]) {
			this.player.setSpeed(new Speed(64, 0));
		}

		if (pkeys[kUP]) {
			this.player.setSpeed(new Speed(0, -64));
		}

		if (pkeys[kDOWN]) {
			this.player.setSpeed(new Speed(0, 64));
		}

		for (int i = 0; i < 4; i++) {
			pkeys[i] = false;
		}
	}
}