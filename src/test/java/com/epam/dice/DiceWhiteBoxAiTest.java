package com.epam.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Dice White Box AI Test")
class DiceWhiteBoxAiTest {

    private static final RandomGenerator generator = RandomGenerator.getDefault();
    
    private static Stream<Arguments> provideValidDiceSidesAndGenerators() {
        return Stream.of(
                Arguments.of(1, generator),
                Arguments.of(Integer.MAX_VALUE, generator)
        );
    }

    @DisplayName("Dice of sides and generator, expecting Dice not null:")
    @ParameterizedTest(name = "[{index}] Positive test with sides {0}")
    @MethodSource("provideValidDiceSidesAndGenerators")
    void diceOfSidesExpectingNotNull(int sides, RandomGenerator randomGenerator) {
        var actual = Dice.of(sides, randomGenerator);
        assertThat(actual)
             .as("Dice must not be null for sides - " + sides)
             .isNotNull();
    }

    private static Stream<Arguments> provideInvalidDiceSides() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1)
        );
    }

    @DisplayName("Dice of invalid sides, expecting IllegalArgumentException:")
    @ParameterizedTest(name = "[{index}] Negative test with sides {0}")
    @MethodSource("provideInvalidDiceSides")
    void diceOfInvalidSidesExpectingException(int sides) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .as("Expected IllegalArgumentException for sides - " + sides)
                .isThrownBy(() -> Dice.of(sides))
                .withMessage("Number of sides must be at least 1");
    }

    @DisplayName("Dice roll test with 6 sides, expecting number from 1 to 6 inclusive:")
    @Test
    void diceRollWith6Sides() {
        var dice = Dice.of(6);
        int rollValue = dice.roll();
        assertThat(rollValue)
             .as("Dice roll must return number from 1 to 6 for sides - 6")
             .isBetween(1, 6);
    }

    @DisplayName("Dice roll test with 1 side, expecting 1:")
    @Test
    void diceRollWith1Side() {
        var dice = Dice.of(1);
        var rollValue = dice.roll();
        assertThat(rollValue)
             .as("Dice only have one side, thus roll value should always be 1")
             .isEqualTo(1);
    }
}
