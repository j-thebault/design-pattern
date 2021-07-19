package org.afcepf.pattern.solution.behavior.command;

public class BritishCook implements Cook {
    @Override
    public void prepareEntree() {
        System.out.println("Preparing some delicious 'Kedgeree'");
    }

    @Override
    public void prepareSoup() {
        System.out.println("Preparing some delicious 'Cream Of Watercress'");
    }
}
