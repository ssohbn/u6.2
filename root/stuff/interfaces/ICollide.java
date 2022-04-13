package root.stuff.interfaces;
import root.stuff.util.Bounds;
import root.stuff.util.Position;
import root.stuff.util.Size;

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

	public CollisionInfo getCollisionInfo();
	
	default boolean colliding(ICollide collider) {
		boolean result = false;
		if (Collisions.withinBounds(this.getBounds(), collider.getBounds())) {
			result = true;

			this.onCollide(collider.getCollisionInfo());
			collider.onCollide(this.getCollisionInfo());

		} 

		return result;
	}

	public void onCollide(CollisionInfo collisionInfo);
	
	default Bounds getBounds() {
		// TODO: check copilot
		return new Bounds(this.getPosition().x, this.getPosition().y, this.getSize().width, this.getSize().height);
	}

	public Position getPosition();

	public Size getSize();

}