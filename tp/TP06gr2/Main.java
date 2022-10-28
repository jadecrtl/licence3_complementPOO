import java.awt.geom.Point2D;

/* tous les tests doivent retourner true */

public class Main {
    public static void main(String[] args) {

        ARS r = ARS.getRectangle(new Point2D.Double(3.0, 3.0),
                new Point2D.Double(7.0, 1.0));
        System.out.println(r.contains(new Point2D.Double(0.5, 0.5)));
        System.out.println(!r.contains(new Point2D.Double(1.1, 1)));
        System.out.println(!r.contains(new Point2D.Double(-1.0, 0.5)));

        //System.out.println("_________________");
        ARS a = ARS.getRectangle( new Point2D.Double(0.0, 0.0), new Point2D.Double( 3.0, 3.0));
        ARS b = ARS.getComplement( ARS.getRectangle( new Point2D.Double(2, 0.5), new Point2D.Double(2.3,2)));
        ARS c = ARS.getIntersect(a,b);


        System.out.println("_________________");
        System.out.println( !c.contains(new Point2D.Double(2.1,1)));
        System.out.println( !c.contains(new Point2D.Double(2.2,0.6)));
        System.out.println( !c.contains(new Point2D.Double(2.1,1.8)));
        System.out.println( c.contains(new Point2D.Double(2.1,0.4)));
        System.out.println( c.contains(new Point2D.Double(2.2,2.1)));
        System.out.println( c.contains(new Point2D.Double(2.4,1.4)));

        ARS s = ARS.getRectangle(new Point2D.Double(0,0), new Point2D.Double(2,3));
        ARS t = ARS.getRectangle( new Point2D.Double(1,1), new Point2D.Double(3,3.5));
        ARS u = ARS.getRectangle( new Point2D.Double(0.5, 2), new Point2D.Double(2.5,2.5));

        ARS x = ARS.getIntersect(ARS.getUnion(s,t) , ARS.getComplement( u ) );

        System.out.println("_________________");
        System.out.println( !x.contains(new Point2D.Double(1, 2.3)));
        System.out.println( !x.contains(new Point2D.Double(2, 2.1)));
        System.out.println( !x.contains(new Point2D.Double(2.1, 0.9)));
        System.out.println( x.contains(new Point2D.Double(1.2, 2.6)));


        System.out.println("_________ y ________");
        ARS y = ARS.getComplement( x );
        System.out.println( y.contains(new Point2D.Double(1, 2.3)));
        System.out.println( y.contains(new Point2D.Double(2, 2.1)));
        System.out.println( y.contains(new Point2D.Double(2.1, 0.9)));
        System.out.println( !y.contains(new Point2D.Double(1.2, 2.6)));

        /*
        System.out.println("verification de simplifyComplement");
        System.out.println("_______ m __________");
        ARS m = ARS.simplifyComplement(y);
        //System.out.println( "y= " + y );
        //System.out.println( "m= " + m );
        System.out.println( m.contains(new Point2D.Double(1, 2.3)));
        System.out.println( m.contains(new Point2D.Double(2, 2.1)));
        System.out.println( m.contains(new Point2D.Double(2.1, 0.9)));
        System.out.println( !m.contains(new Point2D.Double(1.2, 2.6)));


        System.out.println("_______ z __________");
        ARS z = ARS.simplifyComplement( ARS.getComplement(ARS.simplifyComplement( x ) ));
        System.out.println( z.contains(new Point2D.Double(1, 2.3)));
        System.out.println( z.contains(new Point2D.Double(2, 2.1)));
        System.out.println( z.contains(new Point2D.Double(2.1, 0.9)));
        System.out.println( !z.contains(new Point2D.Double(1.2, 2.6)));
        */

    }
}
