package TP3;

public class Tests {
  public static void main(String[] args) {
    // System.out.println((int)true); // compilation error
    System.out.println((int)'a'); // widening, going from smaller (narrowed class) to a wider clas
    System.out.println((byte) 'a');
    System.out.println((byte) 257);
    System.out.println((char) 98);
    System.out.println((double) 98);
    System.out.println((char) 98.12);
    System.out.println((long) 98.12);
    // System.out.println((boolean) 98.); // compilation error
    System.out.println((B) new A()); // execution error
    //System.out.println((C) new B()); // compilation error
    System.out.println((A) new C());

  }
}
