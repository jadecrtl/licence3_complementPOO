import java.awt.geom.Point2D;

public interface ARS {
    boolean contains(Point2D.Double p);

    /* fabriques static */

    static ARS getUnion(ARS p, ARS q) {
        return new Union(p, q);
    }

    static ARS getIntersect(ARS p, ARS q){
        return new Intersect(p, q);
    }

    static ARS getComplement(ARS p ){
        return new Complement(p);
    }

    static ARS getRectangle(Point2D.Double a, Point2D.Double c){
        return new RectangleSimple(a, c);
    }

    //   static ARS simplifyComplement(ARS f) { }

}
