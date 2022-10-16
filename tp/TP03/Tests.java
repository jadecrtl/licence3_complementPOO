class A {}

class B extends A {}

class C extends A {}

public class Tests {
    public static void main(String[] args) {
        System.out.println((int) 'a'); //affiche 97
        System.out.println((byte) 'a'); //affiche 97
        System.out.println((byte) 257); //affiche 1
        System.out.println((char) 98); //affiche b
        System.out.println((double) 98); //affiche 98.0
        System.out.println((char) 98.12); //affiche b
        System.out.println((long) 98.12); //affiche 98
        System.out.println((A) new C()); //affiche C@36aa7bc2 (l'adresse de l'objet)
    }
}