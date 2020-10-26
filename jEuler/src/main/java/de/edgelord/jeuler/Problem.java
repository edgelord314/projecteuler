package de.edgelord.jeuler;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Superclass for programmatic
 * solution to euler problems.
 * All subclasses have to be names like so: <br>
 * {@code ProblemX} <br>
 * where {@code X} is the {@code index} of the
 * problem.
 *
 * @author Malte Dostal
 */
public abstract class Problem {
    private final int index;
    public static final Map<Integer, Problem> PROBLEMS = new HashMap<>();

    public Problem(final int index) {
        this.index = index;
    }

    public static void initAll() throws Exception {
        final InputStream problemsStream = Problem.class.getClassLoader().getResourceAsStream("problems.txt");
        final List<String> problemNames = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(problemsStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    problemNames.add(line);
                }
            }
        }

        for (final String problemName : problemNames) {
            final Problem problem = Class.forName(problemName).asSubclass(Problem.class).getConstructor().newInstance();
            PROBLEMS.put(problem.getIndex(), problem);
        }
    }

    public abstract Object solve();

    public static Problem getProblemByIndex(final int index) {
        return PROBLEMS.get(index);
    }

    public int getIndex() {
        return index;
    }
}
