package de.edgelord.jeuler;

import java.math.BigInteger;

public abstract class LongProblem extends Problem {
    public LongProblem(int index) {
        super(index);
    }

    @Override
    public abstract Long solve();
}
