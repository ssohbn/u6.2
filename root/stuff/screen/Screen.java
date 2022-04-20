package root.stuff.screen;

import java.util.ArrayList;

import root.Sketch;
import root.stuff.interfaces.ICollide;
import root.stuff.interfaces.IDraw;
import root.stuff.interfaces.IMove;

public abstract class Screen {
	
	public ArrayList<IDraw> drawables = new ArrayList<IDraw>();
	public ArrayList<IMove> moveables = new ArrayList<IMove>();
	public ArrayList<ICollide> collidables = new ArrayList<ICollide>();

	protected Sketch sketch;

	public Screen(Sketch sketch) {
		this.sketch = sketch;
	}

	public abstract void draw();
	public abstract void update();
	public abstract void hud();
	public abstract void handleKeydown(int keyCode);
	public abstract void handleKeyup(int keyCode);

}