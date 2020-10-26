package de.edgelord.jeuler;

public class ProjectEuler {

    public static final int[] ONLY_SOLVE = {1, 2};
    public static void main(String[] args) throws Exception {
        Problem.initAll();

        if (ONLY_SOLVE.length > 0) {
            for (final int i : ONLY_SOLVE) {
                printSolution(Problem.PROBLEMS.get(i));
            }
        } else {
            for (final Problem problem : Problem.PROBLEMS.values()) {
                printSolution(problem);
            }
        }
    }

    private static void printSolution(final Problem p) {
        System.out.println("Problem " + p.getIndex() + ": " + p.solve());
    }
}
