package org.afcepf.pattern.training.behavior.observer;

public class ObserverOne implements Observer{
    private final SharedCounter counter;

    public ObserverOne(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void notifyEvent() {
        // ici on réagit à un evenement envoyé par le Subject
        throw new UnsupportedOperationException("IMPLEMENT ME PLEASE");
    }

    //methode propre à la classe ObserverOne, rien à voir avec notre pattern...
    public void aMethod(){

    }
}
