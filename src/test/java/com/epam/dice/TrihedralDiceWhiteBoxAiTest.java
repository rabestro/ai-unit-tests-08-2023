package com.epam.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TrihedralDice White Box AI Test")
class TrihedralDiceWhiteBoxAiTest {

    @DisplayName("Creating TrihedralDice, expecting non-null:")
    @Test
    void creatingTrihedralDiceExpectingNonNull() {
        var dice = new TrihedralDice();
        assertThat(dice)
            .as("TrihedralDice object must not be null when created")
            .isNotNull();
    }

    @DisplayName("Rolling the TrihedralDice 100 times, expecting a number in the range 1-3 every time:")
    @Test
    void rollingTheTrihedralDiceExpectingNumberInCorrectRange() {
        var dice = new TrihedralDice();
        IntStream.range(0, 100).forEach(x -> {
            var rollValue = dice.roll();
            assertThat(rollValue)
                .as("Roll value must be between 1 and 3 (inclusive) for a TrihedralDice")
                .isBetween(1, 3);
        });
    }
}
