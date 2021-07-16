package org.afcepf.pattern.training.behavior.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void shouldMove() {
        Animal animal = new Animal();
        animal.move();
        animal.move();
        assertEquals(20, animal.getDistance());
        animal.transformIntoFlyer();
        animal.move();
        assertEquals(40, animal.getDistance());
        animal.transformIntoSwimmer();
        animal.move();
        assertEquals(42, animal.getDistance());
    }
}
