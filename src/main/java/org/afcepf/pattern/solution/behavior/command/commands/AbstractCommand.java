package org.afcepf.pattern.solution.behavior.command.commands;

import org.afcepf.pattern.solution.behavior.command.Bill;
import org.afcepf.pattern.solution.behavior.command.Priced;

import static java.util.Objects.requireNonNull;

public abstract class AbstractCommand implements Command, Priced {

    private final Bill bill;

    protected AbstractCommand(Bill bill) {
        this.bill = requireNonNull(bill);
    }

    // Petit pattern Template Method au passage
    @Override
    public void execute() {
        cook();
        bill.addPriced(this);
    }

    protected abstract void cook();
}
