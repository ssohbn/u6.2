public class WaterTile extends Tile implements ICollide {
	public WaterTile (Position position, Size size) {
		this.size = size;
		this.position = position;
		this.color = new Color(0, 0, 130);
	}

	public Bounds getBounds() {
    return new Bounds(this.position.x, this.position.x+this.size.width, this.position.y, this.position.y+this.size.height);
  }
}