package org.afcepf.pattern.solution.creation.builder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// * - 	La propriété RAM ne peut prendre que des valeurs de puissance de 2 de 1Go à 1024Go (1,2,4,8...1024)
class MemoryTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 12, 2048})
    public void shouldRefuseInvalidMemoryCapacity(int invalidCapacity) {
        assertThrows(IllegalArgumentException.class, () -> new Memory(invalidCapacity));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024})
    public void shouldAcceptValidMemoryCapacity(int validCapacity) {
        Memory memory = new Memory(validCapacity);
        assertNotNull(memory);
        assertEquals(validCapacity, memory.getCapacity());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    public void shouldSayCapacityIsAtLeast(int atLeast) {
        Memory memory = new Memory(8);
        Memory atLeastMemory = new Memory(atLeast);
        assertTrue(memory.compareTo(atLeastMemory) >= 0);
        assertTrue(memory.capacityIsAtLeast(atLeastMemory));
    }

    @ParameterizedTest
    @ValueSource(ints = {16, 32})
    public void shouldSayCapacityIsNotAtLeast(int atLeast) {
        Memory memory = new Memory(8);
        Memory atLeastMemory = new Memory(atLeast);
        assertTrue(memory.compareTo(atLeastMemory) < 0);
        assertFalse(memory.capacityIsAtLeast(atLeastMemory));
    }
}
