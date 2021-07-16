package org.afcepf.pattern.solution.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    // implementer ici vos methodes
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        observers.forEach(Observer::notifyEvent);
    }

}
