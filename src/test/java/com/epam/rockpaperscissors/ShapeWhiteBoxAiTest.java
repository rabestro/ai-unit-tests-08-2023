package com.epam.rockpaperscissors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Shape tests:")
class ShapeWhiteBoxAiTest {

    @DisplayName("beats function:")
    @ParameterizedTest(name = "[{index}] {0}: ({1}, {2})")
    @CsvSource(delimiter = '|', textBlock = """
        rock beats scissors        | ROCK     | SCISSORS  | true
        paper beats rock           | PAPER    | ROCK      | true
        scissors beats paper       | SCISSORS | PAPER     | true
        same shapes don't beat     | ROCK     | ROCK      | false
        rock doesn't beat paper    | ROCK     | PAPER     | false
        paper doesn't beat scissors| PAPER    | SCISSORS  | false
        scissors doesn't beat rock | SCISSORS | ROCK      | false
        """)
    void beatsFunctionTest(String scenario, Shape shape1, Shape shape2, boolean expectedResult) {
        var actual = shape1.beats(shape2);
        assertThat(actual)
			.as("%s should return %b", scenario, expectedResult)
			.isEqualTo(expectedResult);
    }

    @DisplayName("from function:")
    @ParameterizedTest(name = "[{index}] from {0} maps to: {1}")
    @CsvSource(delimiter = '|', textBlock = """
        rock    | rock     | ROCK
        paper   | paper    | PAPER
        scissors| scissors | SCISSORS
        """)
    void fromFunctionMapsToString(String scenario, String input, Shape expectedResult) {
        var actual = Shape.from(input);
        assertThat(actual)
			.as("String '%s' should map to shape: %s", input, expectedResult)
			.isEqualTo(expectedResult);
    }

    @DisplayName("from function throws on unknown shape")
    @Test
    void fromFunctionThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Shape.from("unknown"));
    }
}
