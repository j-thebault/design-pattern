package org.afcepf.pattern.solution.behavior.state;

import static org.afcepf.pattern.solution.behavior.state.Cancelled.CANCELLED;
import static org.afcepf.pattern.solution.behavior.state.Sent.SENT;

// statut initial, il n'y a pas de methode pour aller vers ce statut
public class Created implements BillState {

    public static final Created CREATED = new Created();

    @Override
    public void send(Bill bill) {
        bill.sendBillByEmail();
        bill.setState(SENT);
    }

    @Override
    public void pay(Bill bill) {
        throw new IllegalArgumentException();
    }

    @Override
    public void cancel(Bill bill) {
        bill.sendCancelled();
        bill.setState(CANCELLED);
    }
}
