package TP2;

import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    // Point a = new Point(3, 5);
    // Point b = new Point(11, 22);

    // System.out.printf("a=%s\n",a);
    // System.out.printf("b=%s\n",b);

    // Point.modifPoint(a, b);
    // System.out.printf("a=%s\n",a);

    // Point o = new Point(-5, -5);
    // System.out.printf("o=%s\n",o);

    // b.addOther(o);
    // System.out.printf("o=%s\n",o);
    // b.addThis(a);

    // System.out.printf("b=%s\n",b);

    Personne p1 = new Personne("Adele", 1254);
    Personne p2 = new Personne("Brian", 1287);
    Personne p3 = new Personne("Coraline", 2546);
    Personne p4 = new Personne("Désire", 2546);

    HashSet<Personne> copains = new HashSet<Personne>();
    copains.add(p1);
    copains.add(p2);
    copains.add(p3);

    Cours couture = new Cours("Couture", copains);
    Cours karate = new Cours("Karate", copains);


    System.out.println(couture);
    System.out.println();
    System.out.println(karate);
    System.out.println();
    System.out.println();
    System.out.println(couture.getInscrits().hashCode());
    System.out.println(karate.getInscrits().hashCode());
    System.out.println();
    
    couture.exclut(p3);
    System.out.println(couture);
    System.out.println();
    System.out.println(karate);
    System.out.println();

    karate.inscrit(p4);
    System.out.println();
    System.out.println(couture);
    System.out.println();
    System.out.println(karate);

    p1.changeNom("NEW NAME");

    System.out.printf("%s\n\n%s", couture, karate);
  }


}
