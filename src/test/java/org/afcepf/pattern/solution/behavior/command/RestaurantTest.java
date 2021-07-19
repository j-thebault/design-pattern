package org.afcepf.pattern.solution.behavior.command;

import org.afcepf.pattern.solution.behavior.command.commands.FrenchCook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Prices
//FrenchSoup = 20;
//BritishSoup = 10;
//FrenchEntree = 50;
//BritishEntree = 60;
class RestaurantTest {

    // les spy permettent de suivre les apples de méthode sur nos véritables objets à la différence des mocks
    // Question bonus : A votre avis quel pattern Mockito utilise-t-il pour permettre cette fonctionnalité ?
    BritishCook britishCook;
    FrenchCook frenchCook;
    Restaurant restaurant;

    @BeforeEach
    void setup() {
        britishCook = Mockito.spy(new BritishCook());
        frenchCook = Mockito.spy(new FrenchCook());
        restaurant = new Restaurant(britishCook, frenchCook);
    }

    @Test
    void cookForClientsCheckCookCalls() {
        restaurant.cookForClients(2, 2, 3, 1);
        Mockito.verify(britishCook, Mockito.times(2)).prepareSoup();
        Mockito.verify(britishCook, Mockito.times(1)).prepareEntree();
        Mockito.verify(frenchCook, Mockito.times(2)).prepareSoup();
        Mockito.verify(frenchCook, Mockito.times(3)).prepareEntree();
    }

    @Test
    void cookForClientsCheckSomeBills() {
        int firstBill = restaurant.cookForClients(2, 2, 3, 1);
        Assertions.assertEquals(270, firstBill);
        int secondBill = restaurant.cookForClients(0, 4, 2, 2);
        Assertions.assertEquals(260, secondBill);
    }

    @Test
    void cookForClientsCheckIllegalCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> restaurant.cookForClients(2, 3, 1, 1));
    }
}
