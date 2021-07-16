package org.afcepf.pattern.training.behavior.observer;

// Exercice
// 1 - Implémenter un pattern observer avec deux classes d'Observers -> test vert
// 2 - Ajouter une troisième classe d'observer, avec juste un syso dans la methode  -> Que remarque-t-on sur le code des autres classes ?

// Commencez par implémenter l'interface Subject
// Implémentez Observer dans les deux classes d'observer

// A noter que ce "simple" pattern observer est la brique de base d'un paradigme de programmation complet : La programmation réactive
// En Java : Voir les librairies RxJava, Spring WebFlux...
// En js : Angular 2+ est en grande partie basé sur la version js de cette librairie : RxJs
public class SubjectImpl implements Subject {

    // implementer ici vos methodes
    @Override
    public void register(Observer observer) {
        throw new UnsupportedOperationException("IMPLEMENT ME PLEASE");
    }

    @Override
    public void unregister(Observer observer) {
        throw new UnsupportedOperationException("IMPLEMENT ME PLEASE");
    }

    @Override
    public void notifyAllObservers() {
        throw new UnsupportedOperationException("IMPLEMENT ME PLEASE");
    }

}
