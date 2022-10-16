package TP1;

public class Main {

  public static void main(String[] args) {
    EvenNumbersGenerator evenClass = new EvenNumbersGenerator();
    System.out.println(evenClass.next());
    System.out.println(evenClass.next());


    VectAdditioner vect = new VectAdditioner();
    vect.add(new VectAdditioner().new Point(5, 10));
    System.out.println(vect);
    vect.add(new VectAdditioner().new Point(5, 10));
    System.out.println(vect);

    SimpleDate date = new SimpleDate(14, 11, 2022);
    System.out.println(date);

    Employe emp = new Employe("Mollo", "Paris", new SimpleDate(10, 2, 2020));
    SimpleDate sp = emp.getDateEmbauche();
    sp.setAnnee(2050);
    System.out.println(emp.getDateEmbauche());
    System.out.println(emp);
    System.out.println(Employe.getChef());

    PreciousStone ps = new PreciousStone.Builder("beryl", "emerald").build();
    System.out.println(ps.getHardness());
    System.out.println(ps.getVariety());

  }
}
