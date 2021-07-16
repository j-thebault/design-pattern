package org.afcepf.pattern.solution.behavior.strategy;

import org.junit.jupiter.api.Test;

import static org.afcepf.pattern.solution.behavior.strategy.Animal.MoveModes.*;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void shouldMove() {
        Animal animal = new Animal();
        animal.move();
        animal.move();
        assertEquals(20, animal.getDistance());
        animal.changeMoveMode(FLY);
        animal.move();
        assertEquals(40, animal.getDistance());
        animal.changeMoveMode(SWIM);
        animal.move();
        assertEquals(42, animal.getDistance());
        animal.changeMoveMode(WALK);
        animal.move();
        assertEquals(47, animal.getDistance());
        animal.changeMoveMode(STAND);
        animal.move();
        animal.move();
        assertEquals(47, animal.getDistance());
    }
}
