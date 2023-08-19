package com.epam.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AbstractDice White Box AI Test")
class AbstractDiceWhiteBoxAiTest {
    @DisplayName("Creating AbstractDice for a valid number of sides, expecting non-null:")
    @ParameterizedTest(name = "[{index}] Test with sides: {0}")
    @ValueSource(ints = {1, 6, Integer.MAX_VALUE})
    void creatingAbstractDiceForValidNumberOfSidesExpectingNonNull(int sides) {
        var dice = new ConcreteDice(sides);
        assertThat(dice)
                .as("AbstractDice object must not be null when created with " + sides + " side(s)")
                .isNotNull();
    }

    @DisplayName("Rolling a 1-sided dice 100 times, expecting 1 every time:")
    @Test
    void rollingThe1SidedDiceExpecting1EveryTime() {
        var dice = new ConcreteDice(1);
        IntStream.range(0, 100).forEach(x -> {
            var rollValue = dice.roll();
            assertThat(rollValue)
                    .as("Roll value must always be 1 for a 1-sided dice")
                    .isEqualTo(1);
        });
    }

    @DisplayName("Rolling a 6-sided dice 100 times, expecting a number in the range 1-6 every time:")
    @Test
    void rollingThe6SidedDiceExpectingNumberInCorrectRange() {
        var dice = new ConcreteDice(6);
        IntStream.range(0, 100).forEach(x -> {
            var rollValue = dice.roll();
            assertThat(rollValue)
                    .as("Roll value must be between 1 and 6 (inclusive) for a 6-sided dice")
                    .isBetween(1, 6);
        });
    }

    private static class ConcreteDice extends AbstractDice {
        ConcreteDice(int sides) {
            super(sides);
        }
    }
}
