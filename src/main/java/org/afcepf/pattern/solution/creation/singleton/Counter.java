package org.afcepf.pattern.solution.creation.singleton;

// Passer le test au vert avec un pattern singleton de base.
public final class Counter {

    private int counter = 0;

    private static final Counter instance = new Counter();

    private Counter() {
    }

    public static Counter getInstance() {
        return instance;
    }

    public void increment() {
        counter++;
    }

    public int getCurrentCount() {
        return counter;
    }
}
