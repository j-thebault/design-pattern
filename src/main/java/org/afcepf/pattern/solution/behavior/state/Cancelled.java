package org.afcepf.pattern.solution.behavior.state;

// Notez que cet état ne fait que throw. Il est terminal, on ne peux pas en sortir...
public class Cancelled implements BillState {

    public static final Cancelled CANCELLED = new Cancelled();

    @Override
    public void send(Bill bill) {
        throw new IllegalArgumentException("Cannot send a cancelled bill !");
    }

    @Override
    public void pay(Bill bill) {
        throw new IllegalArgumentException("Cannot pay a canceled bill");
    }

    @Override
    public void cancel(Bill bill) {
        throw new IllegalArgumentException("Cannot cancel a canceled bill");
    }
}
