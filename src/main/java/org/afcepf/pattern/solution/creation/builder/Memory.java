package org.afcepf.pattern.solution.creation.builder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Memory implements Comparable<Memory>{
    public static final Memory _1GO = new Memory(1);
    public static final Memory _4GO = new Memory(4);

    private final int capacity;

    private static final int maxExponent = 10;

    public Memory(int capacity) {
        this.capacity = validateCapacity(capacity);
    }

    private int validateCapacity(int capacity) {
        List<Integer> validCapacities = findValidCapacities();
        if (validCapacities.contains(capacity)) {
            return capacity;
        }
        throw new IllegalArgumentException("Invalid Memory capacity " + capacity);
    }

    private List<Integer> findValidCapacities() {
        return IntStream.range(0, maxExponent + 1)
                .map(operand -> (int) Math.pow(2, operand))
                .boxed()
                .collect(Collectors.toList());
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean capacityIsAtLeast(Memory atLeast) {
        return this.compareTo(atLeast) >= 0;
    }

    @Override
    public int compareTo(Memory memory) {
        return this.capacity - memory.capacity;
    }
}
