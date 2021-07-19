package org.afcepf.pattern.solution.behavior.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void refuseInvalidPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Price(-2));
    }

    @Test
    void acceptValidPrice() {
        Price price = new Price(5);
        Assertions.assertEquals(5, price.getPrice());
    }
}
