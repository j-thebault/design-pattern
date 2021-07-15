package org.afcepf.pattern.solution.creation.builder;

import org.junit.jupiter.api.Test;

import static org.afcepf.pattern.solution.creation.builder.Memory._1GO;
import static org.afcepf.pattern.solution.creation.builder.Memory._4GO;
import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.*;
import static org.afcepf.pattern.solution.creation.builder.Processor.AMD_3700X;
import static org.afcepf.pattern.solution.creation.builder.Processor.APPLE_M1;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

// - La propriété CPU ne peut prendre que trois valeurs possibles "Intel i7", "Apple M1", "AMD-3700X" et ne peut pas être nulle
//   -  La propriété RAM ne peut prendre que des valeurs de puissance de 2 de 1Go à 1024Go (1,2,4,8...1024) et ne peut pas être nulle
//   -  La propriété OS ne peut prendre que 3 valeurs : "Windows", "Debian", "MacOS" et ne peut pas être nulle
//   -  La propriété OS ne peut prendre la valeur "MacOS" que si le processeur est de type "Apple M1"
//   -  La propriété OS ne peut prendre la valeur "Windows" ou "Debian" que si le processeur est de type "Intel i7" ou "AMD-3700X"
//   -  La propriété OS ne peut prendre la valeur "Windows" si la ram est de moins de 4 Go
class ComputerTest {

    @Test
    public void shouldHaveNonNullCpu(){
        assertThrows(NullPointerException.class, () -> new Computer(null, new Memory(8), DEBIAN));
    }

    @Test
    public void shouldHaveNonNullMemory(){
        assertThrows(NullPointerException.class, () -> new Computer(AMD_3700X, null, WINDOWS));
    }

    @Test
    public void shouldHaveNonNullOperatingSystem(){
        assertThrows(NullPointerException.class, () -> new Computer(AMD_3700X, new Memory(8), null));
    }

    @Test
    public void shouldRefuseInvalidMemorySpec(){
        assertThrows(IllegalArgumentException.class, () -> new Computer(AMD_3700X, _1GO, WINDOWS));
    }

    @Test
    public void shouldRefuseInvalidOsSpec(){
        assertThrows(IllegalArgumentException.class, () -> new Computer(AMD_3700X, _4GO, MAC_OS));
        assertThrows(IllegalArgumentException.class, () -> new Computer(APPLE_M1, _4GO, WINDOWS));
    }

    @Test
    public void shouldBuildValidComputer(){
        assertDoesNotThrow(() -> new Computer(AMD_3700X, new Memory(8), DEBIAN));
    }
}
