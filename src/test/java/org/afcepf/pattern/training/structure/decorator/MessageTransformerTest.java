package org.afcepf.pattern.training.structure.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageTransformerTest {

    @Test
    void upperCaseAndTrimAndSnake() {
        String result = new TransformerA().transform(" Hello world ");
        Assertions.assertEquals("HELLO-WORLD", result);
    }

    @Test
    void lowerCaseAndTrimAndSnake() {
        String result = new TransformerB().transform(" Hello world ");
        Assertions.assertEquals("hello-world", result);
    }

    @Test
    void upperCaseAndAddSpaceAndSnake() {
        String result = new TransformerC().transform("Hello world");
        Assertions.assertEquals(" HELLO-WORLD ", result);
    }

    @Test
    void lowerCaseAndTrimAndUnderscore() {
        String result = new TransformerD().transform(" Hello world ");
        Assertions.assertEquals("hello_world", result);
    }
}
