package com.epam.rockpaperscissors.dice;

import java.util.random.RandomGenerator;

@FunctionalInterface
public interface Dice {
    int roll();

    static Dice of(int sides) {
        return of(sides, RandomGenerator.getDefault());
    }

    static Dice of(int sides, RandomGenerator randomGenerator) {
        if (sides < 1) {
            throw new IllegalArgumentException("Number of sides must be at least 1");
        }
        return () -> randomGenerator.nextInt(sides) + 1;
    }
}
