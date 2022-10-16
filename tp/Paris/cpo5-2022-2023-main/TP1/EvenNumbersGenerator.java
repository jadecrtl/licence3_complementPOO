package TP1;

public class EvenNumbersGenerator {
  public static final int MAX = 42; // I can see but can't modify
  private int previous = 0; // Can't see so can't change.

  public int next() {
    previous += 2; previous %= MAX;
    return previous;
  }
}
