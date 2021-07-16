package org.afcepf.pattern.solution.behavior.state;

// un methode pour aller vers chaque statut non initial.
public interface BillState {
    void send(Bill bill);
    void pay(Bill bill);
    void cancel(Bill bill);
}
