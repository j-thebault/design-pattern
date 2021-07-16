package org.afcepf.pattern.training.behavior.observer;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyAllObservers();
}
