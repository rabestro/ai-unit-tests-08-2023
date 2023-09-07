package com.epam.smallestvalue;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("BlackBox C4 Test for SmallestValueFunction")
class SmallestValueFunctionBlackBoxC4Test {

    @DisplayName("Happy Path test cases")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest(name = "[{index}] {0}: m={1} -> n={2}")
    @CsvSource(delimiter = '|', textBlock = """
            Edge case where 'm' equals 1                                        | 1                     | 2
            Edge case where 'm' equals Long.MAX_VALUE                           | 9223372036854775807   | 21
            Condition where 'n!' is less than 'm' which is less than '(n+1)!'   | 4                     | 3
            Case where 'm' equals 2                                             | 2                     | 3
            Case where 'm' equals 5                                             | 5                     | 3
            Case where 'm' equals 6                                             | 6                     | 4
            """)
    void happyPathTest(String description, long m, int expectedN) {
        var smallestValueFunction = new SmallestValueFunction();
        var result = smallestValueFunction.applyAsInt(m);
        assertThat(result)
                .as("Smallest value that satisfied the condition for m=" + m)
                .isEqualTo(expectedN);
    }

    @Test
    @DisplayName("Edge case where 'm' equals Long.MAX_VALUE")
    void mEqualsLongMaxValueTest() {
        var smallestValueFunction = new SmallestValueFunction();
        assertTimeout(Duration.ofSeconds(5), () -> {
            var result = smallestValueFunction.applyAsInt(Long.MAX_VALUE);
            assertThat(result)
                    .as("Smallest value that satisfies the condition for m=Long.MAX_VALUE")
                    .isEqualTo(21);
        });
    }

    @Test
    @DisplayName("Case where 'm' equals 0")
    void mEqualsZeroTest() {
        var smallestValueFunction = new SmallestValueFunction();
        assertThatThrownBy(() -> smallestValueFunction.applyAsInt(0L))
                .as("Expecting IllegalArgumentException for m=0")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Negative edge case where 'm' equals Long.MIN_VALUE")
    void mEqualsLongMinValueTest() {
        var smallestValueFunction = new SmallestValueFunction();
        assertThatThrownBy(() -> smallestValueFunction.applyAsInt(Long.MIN_VALUE))
                .as("Expecting IllegalArgumentException for m=Long.MIN_VALUE")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("A test case where 'm' equals -1")
    void mEqualsNegativeOneTest() {
        var smallestValueFunction = new SmallestValueFunction();
        assertThatThrownBy(() -> smallestValueFunction.applyAsInt(-1L))
                .as("Expecting IllegalArgumentException for m=-1")
                .isInstanceOf(IllegalArgumentException.class);
    }
}