package org.afcepf.pattern.solution.creation.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterTest {

    @Test
    void testSingleton() {
        Counter instance = Counter.getInstance();
        Counter instance2 = Counter.getInstance();
        instance.increment();
        instance2.increment();
        assertEquals(2, instance.getCurrentCount());
        assertEquals(2, instance2.getCurrentCount());
        assertEquals(instance, instance2);
    }
}
