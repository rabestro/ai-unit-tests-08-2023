package com.epam.flipflop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class FlipFlopPredicateWhiteBoxAiTest {
    @DisplayName("Evaluates flip-flop predicate:")
    @ParameterizedTest(name = "[{index}] when state {0}, LHS {1}, RHS {2} it should return {3} and final state is {4}")
    @CsvSource(delimiter = '|', textBlock =
            """
            false | true  | false | true  | true
            false | true  | true  | true  | false
            true  | true  | false | true  | true
            true  | true  | true  | true  | false
            false | false | false | false | false
            false | false | true  | false | false
            true  | false | false | true  | true
            true  | false | true  | true  | false
            """
    )
    void evaluatesFlipFlopPredicate(
            boolean initState,
            boolean lhsOutput,
            boolean rhsOutput,
            boolean expectedOutput,
            boolean expectedState
    ) {
        Predicate<Object> lhs = x -> lhsOutput;
        Predicate<Object> rhs = x -> rhsOutput;
        var flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        flipFlopPredicate.state = initState;

        var actualOutput = flipFlopPredicate.test(null);

        assertThat(actualOutput)
                .as("When State is %s, LHS Output is %s and RHS Output is %s, then expected output should be %s", initState, lhsOutput, rhsOutput, expectedOutput)
                .isEqualTo(expectedOutput);
        
        assertThat(flipFlopPredicate.state)
                .as("Final state should be %s", expectedState)
                .isEqualTo(expectedState);
    }
}
