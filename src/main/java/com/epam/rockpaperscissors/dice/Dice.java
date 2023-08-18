package com.epam.rockpaperscissors.dice;

import java.util.Objects;
import java.util.random.RandomGenerator;

@FunctionalInterface
public interface Dice {
    int roll();

    static Dice of(int sides) {
        Objects.checkFromToIndex(1, sides, Integer.MAX_VALUE);
        var random = RandomGenerator.getDefault();
        return () -> random.nextInt(sides) + 1;
    }
}
