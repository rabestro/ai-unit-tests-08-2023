package com.epam.rockpaperscissors.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Testing Dice class")
class DiceWhiteBoxAiTest {

    @ParameterizedTest(name = "[{index}] number of sides {0}")
    @ValueSource(ints = {6, 1000000})
    @DisplayName("Check positive numbers")
    void testPositiveNumbers(int sides) {
        var dice = Dice.of(sides);
        var result = dice.roll();
        assertThat(result).as("Check that result is between 1 and " + sides).isBetween(1, sides);
    }

    @DisplayName("Check invalid numbers")
    @ParameterizedTest(name = "[{index}] number of sides {0}")
    @CsvSource(delimiter = '|', textBlock = """
           zero | 0
           negative | -5
       """)
    void testInvalidNumbers(String scenario, int sides) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .as("Check that IndexOutOfBoundsException is thrown for " + scenario)
                .isThrownBy(() -> Dice.of(sides));
    }
}
