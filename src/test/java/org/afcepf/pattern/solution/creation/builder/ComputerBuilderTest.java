package org.afcepf.pattern.solution.creation.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.afcepf.pattern.solution.creation.builder.Memory.*;
import static org.afcepf.pattern.solution.creation.builder.OperatingSystem.*;
import static org.afcepf.pattern.solution.creation.builder.Processor.INTEL_I7;
import static org.junit.jupiter.api.Assertions.*;

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
