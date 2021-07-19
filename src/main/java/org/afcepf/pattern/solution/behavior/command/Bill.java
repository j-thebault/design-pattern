package org.afcepf.pattern.solution.behavior.command;

// Bill peut aussi être vu comme un receveur de command même si elle est partagée entre plusieurs commandes du coup...
public class Bill {

    private int total;

    public int makeTotal() {
        return total;
    }

    public void addPriced(Priced priced) {
        total += priced.price().getPrice();
    }
}
