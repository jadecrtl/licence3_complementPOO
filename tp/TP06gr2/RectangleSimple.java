import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D;

public class RectangleSimple implements ARS{

    private Point2D.Double a;
    private Point2D.Double b;
    private Point2D.Double c;
    private Point2D.Double d;


    public RectangleSimple(Point2D.Double a, Point2D.Double c){
        if (!(a.getX() <= c.getX() || a.getY() <= c.getY())) {
            throw new IllegalArgumentException("Les sommets ne sont pas bien disposés");
        }
        this.a = a;
        this.c = c;
        this.b = new Point2D.Double(c.getX(), a.getY());
        this.d = new Point2D.Double(a.getX(), c.getY());
        if ((b.getY()-a.getY())/(b.getX()-a.getX()) != (c.getY()-d.getY())/(c.getX()-d.getX())) {
            throw new IllegalArgumentException("les segments ne sont pas parallèles");
        }
    }   

    @Override
    public boolean contains(Double p) {
        return false;
    }
    
}
