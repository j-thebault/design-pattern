package org.afcepf.pattern.solution.behavior.command.commands;

import org.afcepf.pattern.solution.behavior.command.Bill;
import org.afcepf.pattern.solution.behavior.command.Price;
import org.afcepf.pattern.solution.behavior.command.commands.AbstractCommand;
import org.afcepf.pattern.solution.behavior.command.commands.FrenchCook;

import static java.util.Objects.requireNonNull;

public class FrenchSoup extends AbstractCommand {

    private final FrenchCook frenchCook;

    public FrenchSoup(FrenchCook frenchCook, Bill bill) {
        super(bill);
        this.frenchCook = requireNonNull(frenchCook);
    }

    @Override
    public Price price() {
        return new Price(20);
    }

    @Override
    protected void cook() {
        this.frenchCook.prepareSoup();
    }
}
