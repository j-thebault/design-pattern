package org.afcepf.pattern.solution.behavior.observer;

public class ObserverTwo implements Observer {
    private final SharedCounter counter;

    public ObserverTwo(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void notifyEvent() {
        counter.increment();
    }

    // Les deux classes d'observables n'ont absolument pas besoin de partager un type commun
    // Elles ont juste besoin d'implémenter toutes deux l'interface Observable
    public void anotherMethod(){

    }
}
