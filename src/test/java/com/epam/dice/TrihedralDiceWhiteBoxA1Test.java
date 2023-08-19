package com.epam.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrihedralDiceWhiteBoxA1Test {

    @DisplayName("Rolls the default Trihedral dice and verifies the results")
    @Test
    void testRoll() {
        var dice = new TrihedralDice();
        var rollResult = dice.roll();

        assertThat(rollResult)
                .as("The result '%d' should be in the inclusive range [1, 3]", rollResult)
                .isBetween(1, 3);
    }
}
