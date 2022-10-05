public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void modifPoint(Point target, Point source) {
        target.x = source.y;
        target.y = source.x;
    }

    public void addThis( Point other ){
        this.x += other.x ;
        this.y += other.y ;
    }

    public void addOther(Point other) {
        other.x += this.x;
        other.y += this.y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

}
