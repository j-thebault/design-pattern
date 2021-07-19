package org.afcepf.pattern.solution.behavior.command;

import org.afcepf.pattern.solution.behavior.command.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.afcepf.pattern.solution.behavior.command.StreamUtils.repeat;

/**
 * Cette classe est dédiées à la création des instances de Commands.
 * C'est une sorte de Factory à commandes, qui contient aussi la règle métier numberOfSoup == numberOfEntree.
 */
public class RequiredMeals {
    private final int requiredFrenchSoup;
    private final int requiredBritishSoup;
    private final int requiredFrenchEntree;
    private final int requiredBritishEntree;
    private final FrenchCook frenchCook;
    private final BritishCook britishCook;
    private final Bill bill;

    public RequiredMeals(int requiredFrenchSoup,
                         int requiredBritishSoup,
                         int requiredFrenchEntree,
                         int requiredBritishEntree,
                         FrenchCook frenchCook,
                         BritishCook britishCook, Bill bill) {
        this.requiredFrenchSoup = requiredFrenchSoup;
        this.requiredBritishSoup = requiredBritishSoup;
        this.requiredFrenchEntree = requiredFrenchEntree;
        this.requiredBritishEntree = requiredBritishEntree;
        this.frenchCook = Objects.requireNonNull(frenchCook);
        this.britishCook = britishCook;
        this.bill = Objects.requireNonNull(bill);
        this.validateMeals();
    }

    private void validateMeals() {
        int numberOfSoup = requiredFrenchSoup + requiredBritishSoup;
        int numberOfEntree = requiredFrenchEntree + requiredBritishEntree;
        if (numberOfSoup != numberOfEntree) {
            throw new IllegalArgumentException("Missing meal in command");
        }
    }

    public List<Command> toCommands() {
        ArrayList<Command> commands = new ArrayList<>();
        repeat(requiredFrenchSoup, () -> commands.add(new FrenchSoup(frenchCook, bill)));
        repeat(requiredBritishSoup, () -> commands.add(new BritishSoup(britishCook, bill)));
        repeat(requiredFrenchEntree, () -> commands.add(new FrenchEntree(frenchCook, bill)));
        repeat(requiredBritishEntree, () -> commands.add(new BritishEntree(britishCook, bill)));
        return commands;
    }

}
