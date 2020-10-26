package de.edgelord.jeuler;

public class Problem2 extends LongProblem {

    public static final long BOUNDS = 4_000_000;

    public Problem2() {
        super(2);
    }

    @Override
    public Long solve() {

        long v1 = 1;
        long v2 = 2;
        long sum = 2;

        while (v2 <= BOUNDS) {
            final long fib = v1 + v2;
            if (fib % 2 == 0) {
                sum += fib;
            }
            v1 = v2;
            v2 = fib;
        }
        return sum;
    }
}
