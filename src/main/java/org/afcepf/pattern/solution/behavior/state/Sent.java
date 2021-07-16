package org.afcepf.pattern.solution.behavior.state;

import static org.afcepf.pattern.solution.behavior.state.Cancelled.CANCELLED;
import static org.afcepf.pattern.solution.behavior.state.Paid.PAID;

public class Sent implements BillState {

    public static final Sent SENT = new Sent();

    @Override
    public void send(Bill bill) {
        bill.sendAgainBillByEmail();
    }

    @Override
    public void pay(Bill bill) {
        bill.sendAcknowledgement();
        bill.setState(PAID);
    }

    @Override
    public void cancel(Bill bill) {
        bill.sendCancelled();
        bill.setState(CANCELLED);
    }
}
