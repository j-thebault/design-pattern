package org.afcepf.pattern.solution.behavior.command.commands;

import org.afcepf.pattern.solution.behavior.command.Bill;
import org.afcepf.pattern.solution.behavior.command.Price;

import static java.util.Objects.requireNonNull;

public class FrenchEntree extends AbstractCommand {

    private final FrenchCook frenchCook;

    public FrenchEntree(FrenchCook frenchCook, Bill bill) {
        super(bill);
        this.frenchCook = requireNonNull(frenchCook);
    }

    @Override
    public Price price() {
        return new Price(50);
    }

    @Override
    protected void cook() {
        this.frenchCook.prepareEntree();
    }
}
