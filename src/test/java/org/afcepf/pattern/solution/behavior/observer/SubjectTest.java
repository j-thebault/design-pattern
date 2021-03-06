package org.afcepf.pattern.solution.behavior.observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubjectTest {

    @Test
    void shouldRegisterAndCallObservers() {
        // créer un compteur
        SharedCounter counter = new SharedCounter();
        // créer trois instance d'observers de deux classes différentes
        Observer observerOne = new ObserverOne(counter);
        Observer observerTwo = new ObserverTwo(counter);
        Observer moreObserverTwo = new ObserverTwo(counter);
        // ajouter le subject et enregistrer les 3 instance d'observers
        Subject subject = new SubjectImpl();
        subject.register(observerOne);
        subject.register(observerTwo);
        subject.register(moreObserverTwo);
        // envoyer un évènement
        subject.notifyAllObservers();
        // vérifiez que la compteur partagé est bien à 3
        Assertions.assertEquals(3, counter.getCount());
        subject.unregister(observerOne);
        // envoyer un second évènement, mais il n'y a plus que deux observers
        subject.notifyAllObservers();
        // vérifiez que la compteur partagé est bien à 5 (et pas 6 ^^)
        Assertions.assertEquals(5, counter.getCount());
    }

}
