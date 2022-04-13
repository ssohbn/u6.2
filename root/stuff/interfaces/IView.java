package root.stuff.interfaces;

import processing.core.PApplet;

public interface IView {
	public void draw(PApplet sketch);
	public void update(PApplet sketch);
	public void hud(PApplet sketch);
	public void handleKeydown(PApplet sketch, int keyCode);
	public void handleKeyup(PApplet sketch, int keyCode);
}
