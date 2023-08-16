package com.epam.flipflop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class FlipFlopPredicateWhiteBoxC4Test {

    @DisplayName("Test FlipFlopPredicate with different lhs and rhs predicates and initial state")
    @ParameterizedTest(name = "Test case {0}: lhs.test()={1}, rhs.test()={2}, initial state={3}, input={4}, expected output={5}, expected state={6}")
    @CsvSource(delimiter = '|', textBlock = """
        1 | false | false | false | any | false | false
        2 | true  | false | false | any | true  | true
        3 | false | true  | false | any | false | false
        4 | true  | true  | false | any | true  | false
        5 | false | false | true  | any | true  | true
        6 | true  | false | true  | any | true  | true
        7 | false | true  | true  | any | true  | false
        8 | true  | true  | true  | any | true  | false
    """)
    void testFlipFlopPredicate(int testCaseId, boolean lhsResult, boolean rhsResult, boolean initialState, String input, boolean expectedOutput, boolean expectedState) {
        Predicate<String> lhs = s -> lhsResult;
        Predicate<String> rhs = s -> rhsResult;
        var flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        flipFlopPredicate.state = initialState;

        var actualOutput = flipFlopPredicate.test(input);

        assertThat(actualOutput)
                .as("Test case %d: expected output is %b", testCaseId, expectedOutput)
                .isEqualTo(expectedOutput);
        assertThat(flipFlopPredicate.state)
                .as("Test case %d: expected state is %b", testCaseId, expectedState)
                .isEqualTo(expectedState);
    }
}
