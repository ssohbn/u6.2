package stuff.util;

public class Color {
    public int r, g, b;
    /**
     *  its a rgb color just make sure its within [0..255]
     * @param r red. must be within [0..255]
     * @param g green. must be within [0..255]
     * @param b blue. must be within [0..255]
     */
    // haha i like javadoc previews
    public Color( int r, int g, int b ) {
        // these better be within [0, 255]
        // google said i cant throw a compile time error :(

        this.r = r;
        this.g = g;
        this.b = b;
    }
    
}
