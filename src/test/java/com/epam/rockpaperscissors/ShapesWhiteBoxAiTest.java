package com.epam.rockpaperscissors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ShapesWhiteBoxAiTest {

    private static final String OPTIONS = "rock,gun,lightning,devil,dragon,water,air"
                                          + ",paper,sponge,wolf,tree,human,snake,scissors,fire";
    private static final Shapes customShapes = new Shapes(OPTIONS);

    @DisplayName("Test contains method with default and custom options")
    @ParameterizedTest(name = "[{index}] Check presence of shape {0} in options {1}: {2}")
    @CsvSource({
            "'rock',     '',                   true",
            "'paper',    '',                   true",
            "'scissors', '',                   true",
            "'spock',    '',                  false",
            "'rock',     'rock,spock,lizard',  true",
            "'spock',    'rock,spock,lizard',  true",
            "'lizard',   'rock,spock,lizard',  true",
            "'paper',    'rock,spock,lizard', false",
    })
    void testContainsWithCustomOptions(String shape, String options, boolean expectedResult) {
        var shapesObject = new Shapes(options);
        var actualResult = shapesObject.contains(shape);

        assertThat(actualResult)
                .as("Presence of shape %s in options %s should be %b", shape, options, expectedResult)
                .isEqualTo(expectedResult);
    }

    @DisplayName("Test random method")
    @Test
    void testRandom() {
        var shapesObject = new Shapes("");
        var randomShape = shapesObject.random();
        assertThat(shapesObject.contains(randomShape))
                .as("Random shape should be present in the shapes list")
                .isTrue();
    }

    @DisplayName("Compare each shape with 'rock'")
    @ParameterizedTest(name = "[{index}] comparing 'rock' with {0}")
    @CsvSource(delimiter = '|', textBlock = """
            rock      |   0
            gun       |  -1
            lightning |  -1
            devil     |  -1
            dragon    |  -1
            water     |  -1
            air       |  -1
            paper     |  -1
            sponge    |   1
            wolf      |   1
            tree      |   1
            human     |   1
            snake     |   1
            scissors  |   1
            fire      |   1
             """)
    void compareRockWithShape(String shape, int expectedResult) {
        var actualResult = customShapes.compare("rock", shape);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("Compare 'water' with each shape")
    @ParameterizedTest(name = "[{index}] comparing 'water' with {0}")
    @CsvSource(delimiter = '|', textBlock = """
            rock      |   1
            gun       |   1
            lightning |   1
            devil     |   1
            dragon    |   1
            water     |   0
            air       |  -1
            paper     |  -1
            sponge    |  -1
            wolf      |  -1
            tree      |  -1
            human     |  -1
            snake     |  -1
            scissors  |   1
            fire      |   1
             """)
    void compareWaterWithShape(String shape, int expectedResult) {
        var actualResult = customShapes.compare("water", shape);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
