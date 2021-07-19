package org.afcepf.pattern.training.behavior.command;

public class FrenchCook implements Cook{
    @Override
    public void prepareEntree() {
        System.out.println("Preparing some delicious 'Oeuf Mimosa'");
    }

    @Override
    public void prepareSoup() {
        System.out.println("Preparing some delicious 'Soupe à l'oignon'");
    }
}
