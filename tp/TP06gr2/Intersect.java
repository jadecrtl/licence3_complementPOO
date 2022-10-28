import java.awt.geom.Point2D;

public class Intersect implements ARS{
    private ARS p;
    private ARS q;

    public Intersect(ARS p, ARS q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public boolean contains(Point2D.Double p) {
        return this.p.contains(p) && this.q.contains(p);
    }
    
    public ARS getP() {
        return p;
    }
    
    public ARS getQ() {
        return q;
    }
    
}
