package root.stuff.screen;

import root.Sketch;

public abstract class Screen {
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