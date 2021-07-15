package org.afcepf.pattern.solution.creation.builder;

import java.util.EnumSet;

import static java.util.EnumSet.of;
import static org.afcepf.pattern.solution.creation.builder.Memory._1GO;
import static org.afcepf.pattern.solution.creation.builder.Memory._4GO;
import static org.afcepf.pattern.solution.creation.builder.Processor.*;

// enum un peu plus riche en métier
// on peut aller très loin avec les enum en java, avant de devoir passer à des hierarchies de classes classiques et plus complexes à gérer
public enum OperatingSystem {
    WINDOWS(_4GO, of(INTEL_I7, AMD_3700X)),
    DEBIAN(_1GO, of(INTEL_I7, AMD_3700X)),
    MAC_OS(_1GO, of(APPLE_M1));

    private final Memory minimalRequiredMemory;
    private final EnumSet<Processor> compatibleProcessors;

    OperatingSystem(Memory minimalRequiredMemory, EnumSet<Processor> compatibleProcessors) {
        this.minimalRequiredMemory = minimalRequiredMemory;
        this.compatibleProcessors = compatibleProcessors;
    }

    void validate(Memory memory){
        if(!memory.capacityIsAtLeast(minimalRequiredMemory)){
            String message = String.format("Insuffisant memory %d for OS %s", memory.getCapacity(), this.name());
            throw new IllegalArgumentException(message);
        }
    }

    public void validate(Processor cpu) {
        // Une petite forme fonctionnelle pour l'exemple
        // Pas sur que ce soit plus lisible qu'un simple if/else mais ça montre une autre façon de faire
        this.compatibleProcessors.stream()
                .filter(compatibleCpu -> compatibleCpu.equals(cpu))
                .findFirst()
                .orElseThrow(() -> { // Optional.isPresent() or throw
                    String message = String.format("Incompatible processor %s for OS %s", cpu.name(), this.name());
                    return new IllegalArgumentException(message);
                });
    }
}
