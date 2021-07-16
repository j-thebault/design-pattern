package org.afcepf.pattern.solution.behavior.state;

public interface Mailer {
    void sendBill();
    void sendAgainBill();
    void sendBillDuplicata();
    void sendAcknowledgement();
    void sendCancelled();
}
