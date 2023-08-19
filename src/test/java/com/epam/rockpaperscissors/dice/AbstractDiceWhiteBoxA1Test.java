package com.epam.rockpaperscissors.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.SplittableRandom;
import java.util.stream.Stream;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractDiceWhiteBoxA1Test {

    private static final long seed = 1347L;
    private static final RandomGenerator seededRg = new SplittableRandom(seed);

    static Stream<Object[]> data() { 
	   var defaultRg = RandomGenerator.getDefault();
        return Stream.of(
            new Object[]{"Test with minimum possible sides (1)",
                         1, defaultRg, 1, 1},
            new Object[]{"Test with 6 sides (common dice)",
                         6, defaultRg, 1, 6},
            new Object[]{"Test with some arbitrary larger number of sides",
                         100, defaultRg, 1, 100},
            new Object[]{"Test with a specific seed for SplittableRandom",
					     10, seededRg, seedGeneratedOutcome(seededRg, 10)[0], seedGeneratedOutcome(seededRg, 10)[1]}
        );
    }

   private static int[] seedGeneratedOutcome(RandomGenerator rg, int sides) {
        int minimum = rg.nextInt(sides) + 1;
        int maximum = minimum;
        for (int i = 1; i < 100; i++) {
            int current = rg.nextInt(sides) + 1;
            if (current < minimum) {
                minimum = current;
            } else if (current > maximum) {
                maximum = current;
            }
        }
        return new int[] {minimum, maximum};
    }

    @DisplayName("Rolls dice and verifies the results:")
    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("data")
    void rollsDiceAndVerifies(String scenario, int sides, RandomGenerator rg, int minExpected, int maxExpected) {
        var dice = new AbstractDice(sides, rg) {};

        var rollResult = dice.roll();
        assertThat(rollResult)
            .as("In scenario '%s', the result '%d' should be in the inclusive range [%d, %d]", 
                 scenario, rollResult, minExpected, maxExpected)
            .isBetween(minExpected, maxExpected);
    }
}
