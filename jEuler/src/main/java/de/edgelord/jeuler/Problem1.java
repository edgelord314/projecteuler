package de.edgelord.jeuler;

public class Problem1 extends LongProblem {
    public static long BOUND = 1000;

    static {
        Problem.PROBLEMS.put(1, new Problem1());
    }
    public Problem1() {
        super(1);
    }

    public Long solve() {
        long sum = 3;
        for (long n = 4; n < BOUND; n++) {
            if (n % 3 == 0 || n % 5 == 0) {
                sum+=n;
            }
        }
        return sum;
    }
}
