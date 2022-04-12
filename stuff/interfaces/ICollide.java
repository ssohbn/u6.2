package stuff.interfaces;
import stuff.util.Bounds;
import stuff.util.Position;

class Collisions {

	public static boolean withinBounds(Bounds bounds1, Bounds bounds) {
		boolean result = false;
        if (
        Collisions.posInBounds(new Position(bounds1.left, bounds1.top), bounds) ||
        Collisions.posInBounds(new Position(bounds1.right, bounds1.top), bounds) ||
        Collisions.posInBounds(new Position(bounds1.left, bounds1.bottom), bounds)||
        Collisions.posInBounds(new Position(bounds1.right, bounds1.bottom), bounds))
				{
        	result = true;
        }
			return result;
    }
	
	public static boolean posInBounds(Position pos, Bounds bounds) {
        if(
            pos.x <= bounds.right && pos.x >= bounds.left &&
            pos.y <= bounds.bottom && pos.y >= bounds.top 
        ) {
					return true;
				} else {
		return false;
		}
	}
}

public interface ICollide {
	
	default boolean colliding(ICollide collider) {
		boolean result = false;
		if (Collisions.withinBounds(this.getBounds(), collider.getBounds())) {
			result = true;
		} 
		return result;
	}

	public void onCollide();
	
	public Bounds getBounds();
	public Position getPosition();

}