package org.afcepf.pattern.solution.behavior.command.commands;

import org.afcepf.pattern.solution.behavior.command.Bill;
import org.afcepf.pattern.solution.behavior.command.BritishCook;
import org.afcepf.pattern.solution.behavior.command.Price;

import static java.util.Objects.requireNonNull;

public class BritishEntree extends AbstractCommand {

    private final BritishCook britishCook;

    public BritishEntree(BritishCook britishCook, Bill bill) {
        super(bill);
        this.britishCook = requireNonNull(britishCook);
    }

    @Override
    public Price price() {
        return new Price(60);
    }

    @Override
    protected void cook() {
        this.britishCook.prepareEntree();
    }
}
