public class EvenNumbersGenerator {
    static int MAX = 42;
    private int previous = 0; //comme ca previous sera toujours init a 0 et sera toujours pair
    public int next() {
        previous += 2; previous %= MAX;
        return previous;
    }
}
