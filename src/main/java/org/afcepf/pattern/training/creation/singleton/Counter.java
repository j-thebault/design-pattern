package org.afcepf.pattern.training.creation.singleton;

// Passer le test au vert avec un pattern singleton de base.
public class Counter {

    private int counter = 0;

    public static Counter getInstance(){
        return new Counter();
    }

    public void increment(){
        counter++;
    }

    public int getCurrentCount(){
        return counter;
    }
}
