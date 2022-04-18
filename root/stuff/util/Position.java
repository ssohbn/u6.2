package root.stuff.util;

public class Position {
    public int x, y;
    /**
     * 
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position add(Speed speed) {
        this.x += speed.x;
        this.y += speed.y;
        return this;
    }
}
