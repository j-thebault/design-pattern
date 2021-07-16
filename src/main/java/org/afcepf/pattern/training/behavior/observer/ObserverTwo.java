package org.afcepf.pattern.training.behavior.observer;

public class ObserverTwo implements Observer{
    private final SharedCounter counter;

    public ObserverTwo(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void notifyEvent() {
        throw new UnsupportedOperationException("IMPLEMENT ME PLEASE");
    }

    // Les deux classes d'observables n'ont absolument pas besoin de partager un type commun
    // Elles ont juste besoin d'implémenter toutes deux l'interface Observable
    public void anotherMethod(){

    }
}
