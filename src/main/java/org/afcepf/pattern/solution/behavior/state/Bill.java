package org.afcepf.pattern.solution.behavior.state;

// 4 états initiaux
// "CREATED"
// "SENT"
// "PAID"
// "CANCELLED"

// Exercice :
//  1 - Refactorer le code ci dessous au moyen d'un pattern State
// J'ai fourni quelques tests sur les transition, il faut les faire évoluer aussi.
// Éventuellement en ajouter s'il en manque...
// 2 - Ajouter un état "PROBLEM" qui ne déclanche aucune operation, est accessible depuis tous les états sauf "CANCELLED", et qui est terminal.
public class Bill {

    private final Mailer mailer;
    private BillState state;

    public Bill(Mailer mailer) {
        this.mailer = mailer;
        state = Created.CREATED;
    }

    public void send() {
        state.send(this);
    }

    public void pay() {
        state.pay(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    void sendCancelled() {
        mailer.sendCancelled();
    }

    void sendAcknowledgement() {
        mailer.sendAcknowledgement();
    }

    void sendDuplicata() {
        mailer.sendBillDuplicata();
    }

    void sendAgainBillByEmail() {
        mailer.sendAgainBill();
    }

    void sendBillByEmail() {
        mailer.sendBill();
    }

    public BillState getState() {
        return state;
    }

    // jamais public ! Seuls les classe du package devrait etre autorisées à changer l'état
    // Si on voulait encapsuler plus on pourrait même mettre les classes d'état directement dans la classe Bill
    void setState(BillState state) {
        this.state = state;
    }
}
