import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(3, 5);
        Point b = new Point(11, 22);
        System.out.printf("a=%s\n", a);
        //modifier a par une methode static?
        Point.modifPoint(a, b);
        System.out.printf("a=%s\n", a);
        Point o = new Point(-5, -5);
        //modifier o par b ?
        b.addOther(o);
        System.out.printf("o=%s\n", o);
        b.addThis(a);
        System.out.printf("b=%s\n", b);

        //On cree un certain nombre de personnes :
        Personne p1 = new Personne("Adèle", 1234);
        Personne p2 = new Personne("Brian", 1287);
        Personne p3 = new Personne("Coralie", 2546);
        Personne p4 = new Personne("Désiré", 1234);

        //On cree un groupe de copains :
        HashSet<Personne> copains = new HashSet<Personne>();
        copains.add(p1);
        copains.add(p2);
        copains.add(p3);

        //Pour ce groupe, on cree 2 cours :
        Cours couture = new Cours("Couture", copains);
        Cours karate = new Cours("Karate", copains);

        //Coralie est exclue du cours de Couture 
        couture.exclut(p3);

        //Désiré s'inscrit à celui de Karaté
        karate.inscrit(p4);

        //Adèle change de prénom, parce que l'ancien ne lui plaisait pas
        p1.changeNom("Adeline");
        System.out.printf("%s\n\n%s", couture, karate);
    }
}
