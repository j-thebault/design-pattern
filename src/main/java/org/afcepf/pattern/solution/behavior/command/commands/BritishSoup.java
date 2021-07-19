package org.afcepf.pattern.solution.behavior.command.commands;

import org.afcepf.pattern.solution.behavior.command.Bill;
import org.afcepf.pattern.solution.behavior.command.BritishCook;
import org.afcepf.pattern.solution.behavior.command.Price;

import static java.util.Objects.requireNonNull;

public class BritishSoup extends AbstractCommand {

    private final BritishCook britishCook;

    public BritishSoup(BritishCook britishCook, Bill bill) {
        super(bill);
        this.britishCook = requireNonNull(britishCook);
    }

    @Override
    public Price price() {
        return new Price(10);
    }

    @Override
    protected void cook() {
        this.britishCook.prepareSoup();
    }
}
