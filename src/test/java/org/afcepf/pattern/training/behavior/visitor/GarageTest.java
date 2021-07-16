package org.afcepf.pattern.training.behavior.visitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageTest {

    @Test
    void shouldRepair() {
        Garage garage = new Garage();
        Assertions.assertDoesNotThrow(garage::repairAll);
        garage.addVehicle(new Car());
        Assertions.assertDoesNotThrow(garage::repairAll);
        garage.addVehicle(new Bus());
        Assertions.assertThrows(IllegalArgumentException.class, garage::repairAll);
    }
}
