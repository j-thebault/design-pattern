package org.afcepf.pattern.solution.behavior.observer;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyAllObservers();
}
