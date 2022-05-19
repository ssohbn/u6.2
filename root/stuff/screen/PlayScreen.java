package root.stuff.screen;

import java.util.ArrayList;
import java.util.Random;

import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.interfaces.IMove;
import root.stuff.interfaces.IRow;
import root.stuff.sprites.Log;
import root.stuff.sprites.vehicles.Car;
import root.stuff.sprites.vehicles.Player;
import root.stuff.tiles.Biome;
import root.stuff.tiles.Desert.DesertRow;
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
	public boolean touchingLog = false;
	public boolean touchingWater = false;

	/* keys */
	boolean[] keys      = new boolean[4];
	boolean[] pkeys     = new boolean[4];
	final int kLEFT 	= 0;
	final int kRIGHT    = 1;
	final int kUP 	    = 2;
	final int kDOWN 	= 3;
	
	public ArrayList<IDraw> drawables = genStartingRows();
	public ArrayList<IMove> moveables = new ArrayList<IMove>();
	public ArrayList<ICollide> collidables = new ArrayList<ICollide>();
	int rowsGenerated = 0;


	public PlayScreen(Sketch sketch) {
		super(sketch);
		this.score = 0;
		this.rowsGenerated = 0;

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

	Biome randomBiome() {
		Random r = new Random();
		int randomNum = r.nextInt(2);
		switch (randomNum) {
			case 0:
				return Biome.FOREST;
			case 1:
				return Biome.DESERT;
			default: // should never run this
				return Biome.GRASSLANDS;
		}
	}

	@Override
	public void update() {
		ArrayList<IDraw> toRemove = new ArrayList<IDraw>();
		ArrayList<ICollide> toRemoveCollidable = new ArrayList<ICollide>();

		boolean shouldGenNewRow = false;
		for (ICollide collider : this.collidables) {
			if (!collider.colliding(player)) continue;

			sketch.screen = new EndScreen(this.sketch, score);
		}
		
		if ( touchingWater && !touchingLog ) {
			sketch.screen = new EndScreen(this.sketch, score);
		}

		playerMovementUpdate();
		for (IMove moveable : moveables) {
			moveable.move();
		}


		for (IDraw drawable : drawables) {
			if (drawable instanceof Log ) {
				System.out.println("log found ");
			}
			drawable.fall(2);

			if (drawable.shouldPurgeOffscreen() ) {
				if (drawable instanceof IRow ) {
					toRemove.add(drawable);
					shouldGenNewRow = true;
				}
			}
		}
		
		for ( ICollide collidable : this.collidables ) {
			if (collidable.shouldPurgeOffscreen() ) {
				toRemoveCollidable.add(collidable);
			}
		}

		for ( IDraw drawable : toRemove) {
			System.out.println("removing drawable: " + drawable);
			drawables.remove(drawable);
		}

		for ( ICollide collidable : toRemoveCollidable ) {
			System.out.println("removing collidable: " + collidable);
			this.collidables.remove(collidable);
		}

		rowGeneration(shouldGenNewRow);
		
		score++;
	}



	public void rowGeneration(boolean shouldGenNewRow) {

		if ( rowsGenerated % 10 == 0) {
			this.biome = Biome.WATER;
		}

		if (shouldGenNewRow) {	
			genNewRow();
			rowsGenerated++;
			if ( this.biome == Biome.WATER) {
				this.biome = randomBiome();
			}
		}
	}

	public void genNewRow() {
		IRow row = null;
		switch (this.biome) {
			case GRASSLANDS:
				row = new GrassLandsRow(-64, sketch);
				break;
			case DESERT:
			row = new DesertRow(-64, sketch);
				break;
			case FOREST:
				row = new ForestRow(-64, sketch);
				break;
			case WATER:
				row = new WaterRow(-64, sketch);
				break;
			default:
				break;
		}
		drawables.add(row);
		if (row instanceof ICollide) {
			this.collidables.add((ICollide) row);
			System.out.println("added new collidable\n - size: " + this.collidables.size());
		}
	}

	@Override
	public void hud() {
		
		sketch.fill(0, 0, 0);
		sketch.textSize(40);
		sketch.text("Cool HUD",80, 1);
		sketch.text("Score: " + score, 100, 30);
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