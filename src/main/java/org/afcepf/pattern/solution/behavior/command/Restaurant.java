package org.afcepf.pattern.solution.behavior.command;

import org.afcepf.pattern.solution.behavior.command.commands.Command;
import org.afcepf.pattern.solution.behavior.command.commands.FrenchCook;

import java.util.List;

/**
 * Restaurant est devenu le client de notre pattern command.
 *  - Les commandes sont crées par la classe RequiredMeals, mais la création est orchéstrée dans la classe Restaurant
 *  - Les receveurs des commandes (FrenchCook, BritishCook et Bill) sont fournies par Restaurant
 *  - L'exécution des commande se fait au niveau de l'invoker.
 *
 *  On Observe un découplage physique entre le code qui crée les commandes et celui qui exécute ces commandes. Donc le code devient plus spécialisé, plus testable et réutilisable.
 *  On peux imaginer d'autres moyens de créer les mêmes commandes et on garde toute notre logique sans avoir besoin de dupliquer du code.
 *
 * Après application du pattern, la classe Restaurant est devenue une sort d'orchéstrateur entre différents objets.
 * C'est une conséquence classique d'un changement de paradigme procédural -> objet.
 * La classe initiale qui contenait "tout" devient une sorte de coordinateurs entre objets plus spécialisés et plus petits.
 * Cela permet à la fois de cacher la complexité interne (role de Façade...) et de maintenir les frontières existantes (ie les méthodes publiques de cet objet, role d'Adapter)
 */
public class Restaurant {

    private final BritishCook britishCook;
    private final FrenchCook frenchCook;

    // On procède par injection directe des cuisiniers ici. Chaque cuisinier sont en fait une sorte de singleton à l'échelle de notre test
    // Dans une vraie application -> Injection de Bean Spring/JEE de scope singleton (aka singleton au niveau du conteneur applicatif)
    public Restaurant(BritishCook britishCook, FrenchCook frenchCook) {
        this.britishCook = britishCook;
        this.frenchCook = frenchCook;
    }

    int cookForClients(int numberOfFrenchSoup,
                       int numberOfBritishSoup,
                       int numberOfFrenchEntree,
                       int numberOfBritishEntree) {

        Bill bill = new Bill();

        List<Command> commands = new RequiredMeals(
                numberOfFrenchSoup,
                numberOfBritishSoup,
                numberOfFrenchEntree,
                numberOfBritishEntree,
                frenchCook,
                britishCook,
                bill // bill et un cook seront passés aux commandes pour qu'elles puissent s'exécuter correctement.
        ).toCommands();

        new CookCommandsInvoker().addCommands(commands).executeCommands();

        return bill.makeTotal();
    }
}
