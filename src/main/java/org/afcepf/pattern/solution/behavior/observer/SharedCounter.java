package org.afcepf.pattern.solution.behavior.observer;

public class SharedCounter {
    private int count;

    synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
