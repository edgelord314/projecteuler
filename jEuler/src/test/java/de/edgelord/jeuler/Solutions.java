package de.edgelord.jeuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solutions {

    @org.junit.jupiter.api.Test
    void solve() {
        assertEquals(233168, Problem.PROBLEMS.get(1).solve());
        assertEquals(4613732, Problem.PROBLEMS.get(2).solve());
    }
}