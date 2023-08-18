package com.epam.rockpaperscissors.dice;

import java.util.random.RandomGenerator;

abstract class AbstractDice implements Dice {
    private final int sides;
    private final RandomGenerator randomGenerator;

    AbstractDice(int sides, RandomGenerator randomGenerator) {
        this.sides = sides;
        this.randomGenerator = randomGenerator;
    }

    AbstractDice(int sides) {
        this(sides, RandomGenerator.getDefault());
    }

    @Override
    public int roll() {
        return randomGenerator.nextInt(sides) + 1;
    }
}
