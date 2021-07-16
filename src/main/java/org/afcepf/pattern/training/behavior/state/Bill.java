package org.afcepf.pattern.training.behavior.state;

// 4 états possibles
// "CREATED"
// "SENT"
// "PAID"
// "CANCELLED"

// Exercice :
// Refactorer le code ci dessous au moyen d'un pattern State
// J'ai fourni quelques tests sur les transition, il faut les faire évoluer aussi.
// Éventuellement en ajouter s'il en manque...
public class Bill {

    private final Mailer mailer;
    private String state;

    public Bill(Mailer mailer) {
        this.mailer = mailer;
        state = "CREATED";
    }

    public void send(){
        switch (state){
            case "CREATED":
                sendBillByEmail();
                state = "SENT";
                break;
            case "SENT" :
                sendAgainBillByEmail();
                break;
            case "CANCELLED":
                throw new IllegalArgumentException("Cannot send a cancelled bill !");
            case "PAID":
                sendDuplicata();
        }
    }

    public void pay() {
        switch (state){
            case "SENT" :
                sendAcknowledgement();
                state = "PAID";
                break;
            case "PAID":
            case "CREATED":
            case "CANCELLED":
                throw new IllegalArgumentException("Cannot pay a bill : " + state);
        }
    }

    public void cancel() {
        switch (state){
            case "CREATED":
            case "SENT" :
                sendCancelled();
                state = "CANCELLED";
                break;
            case "PAID":
            case "CANCELLED":
                throw new IllegalArgumentException("Cannot cancel a bill : " + state);
        }
    }

    private void sendCancelled() {
        mailer.sendCancelled();
    }

    private void sendAcknowledgement() {
        mailer.sendAcknowledgement();
    }

    private void sendDuplicata() {
        mailer.sendBillDuplicata();
    }

    private void sendAgainBillByEmail() {
        mailer.sendAgainBill();
    }

    private void sendBillByEmail() {
        mailer.sendBill();
    }

    public String getState() {
        return state;
    }


}
