package org.afcepf.pattern.solution.behavior.state;

//statut terminal on ne peut plus changer d'état
public class Paid implements BillState {

    public static final Paid PAID = new Paid();

    @Override
    public void send(Bill bill) {
        bill.sendDuplicata();
    }

    @Override
    public void pay(Bill bill) {
        throw new IllegalArgumentException("Cannot pay a bill two times.");
    }

    @Override
    public void cancel(Bill bill) {
        throw new IllegalArgumentException("Cannot cancel a paid bill");
    }
}
