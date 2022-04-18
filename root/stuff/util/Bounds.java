package root.stuff.util; 

public class Bounds {
	 public int left, right, top, bottom;
    public Bounds(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public Bounds(Position position, Size size) {
		this.left = position.x;
		this.right = position.x + size.width;
		this.top = position.y;
		this.bottom = position.y + size.height;
	}

	public void display() {
        System.out.println("left: " + this.left);
        System.out.println("right: " + this.right);
        System.out.println("top: " + this.top);
        System.out.println("bottom: " + this.bottom);
    }
}