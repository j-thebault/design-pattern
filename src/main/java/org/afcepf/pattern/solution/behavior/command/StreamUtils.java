package org.afcepf.pattern.solution.behavior.command;

import java.util.stream.IntStream;

public class StreamUtils {
    public static void repeat(int times, Runnable runnable) {
        IntStream.range(0, times).forEach((i) -> runnable.run());
    }
}
