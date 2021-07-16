package org.afcepf.pattern.training.behavior.state;

public interface Mailer {
    void sendBill();
    void sendAgainBill();
    void sendBillDuplicata();
    void sendAcknowledgement();
    void sendCancelled();
}
