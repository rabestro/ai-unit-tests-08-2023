package com.epam.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DiceWhiteBoxA2Test {

    @DisplayName("Creating a dice with various sides")
    @ParameterizedTest(name = "[{index}] with sides {0}")
    @CsvSource(delimiter = '|', textBlock = """
                min side       |   1
                more than min  |  10
                max side       |   2147483647
            """)
    void rollTest(String scenario, int sides) {
        var dice = Dice.of(sides);
        var actual = dice.roll();
        assertThat(actual)
                .as("Roll result should be within 1 and %s", sides)
                .isBetween(1, sides);
    }

    @DisplayName("Creating a dice with a custom random generator")
    @ParameterizedTest(name = "[{index}] with custom RandomGenerator and sides {0}")
    @ValueSource(ints = {6})
    void rollWithCustomRandomGeneratorTest(int sides) {
        RandomGenerator randomGenerator = new Random()::nextInt;
        var dice = Dice.of(sides, randomGenerator);
        var actual = dice.roll();
        assertThat(actual)
                .as("Roll result should be within 1 and %s", sides)
                .isBetween(1, sides);
    }

    @DisplayName("Creating a dice with invalid sides")
    @ParameterizedTest(name = "[{index}] with sides {0}")
    @ValueSource(ints = {0, -10})
    void invalidSidesTest(int sides) {
        assertThatThrownBy(() -> Dice.of(sides))
                .as("Should throw IllegalArgumentException for sides %s.", sides)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
