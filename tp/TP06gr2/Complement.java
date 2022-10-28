import java.awt.geom.Point2D;

public class Complement implements ARS{
    private ARS p;

    public Complement(ARS p) {
        this.p = p;
    }

    @Override
    public boolean contains(Point2D.Double p) {
        return !this.p.contains(p);
    }
    
    public ARS getP() {
        return p;
    }
        
}
