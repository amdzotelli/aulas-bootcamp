package util;

public class NumberGenerator {
    private int next;
    private final static NumberGenerator instancia = new NumberGenerator();
    // garante que só vai ter um number generator -- Singleton

    private NumberGenerator() {

    }

    public static NumberGenerator getInstance() {
        return instancia;
    }

    public int getNext() {
        return ++next;
    }
}
