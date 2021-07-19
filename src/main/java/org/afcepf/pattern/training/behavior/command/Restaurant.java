package org.afcepf.pattern.training.behavior.command;

/**
 * Examiner le code ci dessous. Comment le qualifier ? Quel est son paradigme dominant ?
 * Comment ça va se passer si on doit ajouter un type de nourriture différente ? Pourquoi ?
 * Refactorez le avec un pattern Command.
 * Vous avez le droit d'utiliser d'autres patterns vu précédemment si nécessaire...
 * <p>
 * Indices :
 * - Il manque clairement des classes importantes, avant même de penser aux design patterns. Faites un "boitograme" rapide pour vous aider.
 * - Il va y avoir deux grand phases dans notre code : Construire les commands et exécuter les commandes. La première sera de loin la plus complexe vu l'exercice...
 * - Vous n'avez pas le droit de remplacer les inputs/outputs de cookForClients car dans le cadre de l'exercice, on imagine qu'ils sont utilisés par du code externe auquel vous n'avez pas accès.
 * - Vous pouvez ajouter des tests aux classes que vous créez...
 */
public class Restaurant {

    private final BritishCook britishCook;
    private final FrenchCook frenchCook;

    public Restaurant(BritishCook britishCook, FrenchCook frenchCook) {
        this.britishCook = britishCook;
        this.frenchCook = frenchCook;
    }

    int cookForClients(int numberOfFrenchSoup,
                        int numberOfBritishSoup,
                        int numberOfFrenchEntree,
                        int numberOfBritishEntree) {

        // Attention il y a une règle métier ici... pas évidente à comprendre au premier coup d'oeil mais elle est bien là
        if((numberOfFrenchSoup + numberOfBritishSoup) != (numberOfFrenchEntree + numberOfBritishEntree)){
            throw new IllegalArgumentException("Missing meal in command");
        }

        int bill = 0;
        int cookedFrenchSoup = 0;
        int cookedBritishSoup = 0;
        int cookedFrenchEntree = 0;
        int cookedBritishEntree = 0;

        while (cookedFrenchSoup < numberOfFrenchSoup) {
            frenchCook.prepareSoup();
            bill += 20;
            cookedFrenchSoup++;
        }

        while (cookedBritishSoup < numberOfBritishSoup) {
            britishCook.prepareSoup();
            bill += 10;
            cookedBritishSoup++;
        }

        while (cookedFrenchEntree < numberOfFrenchEntree) {
            frenchCook.prepareEntree();
            bill += 50;
            cookedFrenchEntree++;
        }

        while (cookedBritishEntree < numberOfBritishEntree) {
            britishCook.prepareEntree();
            bill += 60;
            cookedBritishEntree++;
        }

        return bill;
    }
}
