package org.afcepf.pattern.solution.creation.builder;

import static org.afcepf.pattern.solution.creation.builder.Memory._4GO;
import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.WINDOWS;
import static org.afcepf.pattern.solution.creation.builder.Processor.INTEL_I7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerBuilderTest {

    @Test
    void shouldCreateComputer() {
        Computer computer = new ComputerBuilder()
                .withCpu(INTEL_I7)
                .withMemory(_4GO)
                .withOperatingSystem(WINDOWS)
                .build();
        Assertions.assertNotNull(computer);
    }
}
