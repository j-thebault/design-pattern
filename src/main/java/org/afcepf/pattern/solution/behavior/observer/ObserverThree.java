package org.afcepf.pattern.solution.behavior.observer;

// Ajouter une nouvelle classe d'observer ne modifie en rien le code des autres classes.
// Seul le client final devra faire en sorte que les observers s'enregistrent dans le subject.
// Découplage complet entre les différentes classe, elles communiquent juste au travers de deux interfaces : Subject et Observer
public class ObserverThree implements Observer {

    @Override
    public void notifyEvent() {
        System.out.println("PING, AN EVENT ARRIVED !!!");
    }
}
