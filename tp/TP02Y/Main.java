import java.util.HashSet;

public class Main {
    
    public static void main(String[] arg) {
        Point a = new Point(3, 5);
        Point b = new Point(11, 22);
        System.out.printf( "a=%s\n",a ); // a = (3,5)
        //modifier a par une méthode static ?
        Point.modifPoint(a, b);
        System.out.printf("a=%s\n", a ); // a = (22,11)
        Point o = new Point( -5, -5);
        //modifier o par b ?
        b.addOther(o);
        System.out.printf("o=%s\n",o); // o = (6, 17)
        b.addThis(a);
        System.out.printf("b=%s\n", b); // b = (33, 33)

        System.out.println("==================");


        Personne p1 = new Personne("Adèle", 1254);
        Personne p2 = new Personne("Brian", 1287);
        Personne p3 = new Personne("Coralie", 2546);
        Personne p4 = new Personne("Désiré", 2546);

        HashSet<Personne> copains = new HashSet<Personne>();
        copains.add(p1);
        copains.add(p2);
        copains.add(p3);

        /*HashSet<Personne> coutureCours = (HashSet)copains.clone();
        HashSet<Personne> karateCours = (HashSet)copains.clone();*/
        //pour ce groupe, on crée 2 cours:
        Cours couture = new Cours("Couture", copains); // Il faut une liste par cours
        Cours karate = new Cours("Karate", copains);
        //Coralie est exclue du cours de Couture // Coralie est exclue de tous les cours
        couture.exclut(p3);
        //Désiré s'inscrit à celui de Karaté // Désiré s'inscrit à tous les cours
        karate.inscrit(p4);
        //Adèle change de prénom, parce que
        // l'ancien ne lui plaisait pas
        p1.changeNom("Adeline");
        System.out.printf("%s\n\n%s\n", couture, karate);
    }
}
