package org.afcepf.pattern.solution.creation.builder;

import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.DEBIAN;
import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.MAC_OS;
import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.WINDOWS;
import static org.afcepf.pattern.solution.creation.builder.Processor.APPLE_M1;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatingSystemTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void windowsShouldRefuseLessThan4Go(int capacity) {
        assertThrows(IllegalArgumentException.class, () -> WINDOWS.validate(new Memory(capacity)));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 16})
    public void windowsShouldAcceptAtLeast4Go(int capacity) {
        assertDoesNotThrow(() -> WINDOWS.validate(new Memory(capacity)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 16})
    public void otherOsShouldAcceptAllMemory(int capacity) {
        assertDoesNotThrow(() -> {
            MAC_OS.validate(new Memory(capacity));
            DEBIAN.validate(new Memory(capacity));
        });
    }

    @ParameterizedTest
    @EnumSource(value = Processor.class, names = {"AMD_3700X", "INTEL_I7"})
    public void macOsRefuseOtherChips(Processor processor) {
        assertThrows(IllegalArgumentException.class, () -> MAC_OS.validate(processor));
    }

    @Test
    public void macOsAcceptOnlyExpensiveMacChips() {
        assertDoesNotThrow(() -> MAC_OS.validate(APPLE_M1));
    }

    @ParameterizedTest
    @EnumSource(value = Processor.class, names = {"AMD_3700X", "INTEL_I7"})
    public void windowsAndLinuxAcceptNonMacOsChips(Processor processor) {
        assertDoesNotThrow(() -> DEBIAN.validate(processor));
        assertDoesNotThrow(() -> WINDOWS.validate(processor));
    }

    @Test
    public void windowsAndLinuxRejectMacOsChips() {
        assertThrows(IllegalArgumentException.class, () -> DEBIAN.validate(APPLE_M1));
        assertThrows(IllegalArgumentException.class, () -> WINDOWS.validate(APPLE_M1));
    }
}
