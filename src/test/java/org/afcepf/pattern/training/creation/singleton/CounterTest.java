package org.afcepf.pattern.training.creation.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    void testSingleton() {
        Counter instance = Counter.getInstance();
        Counter instance2 = Counter.getInstance();
        instance.increment();
        instance2.increment();
        Assertions.assertEquals(2, instance.getCurrentCount());
        Assertions.assertEquals(2, instance2.getCurrentCount());
        Assertions.assertEquals(instance, instance2);
    }
}
