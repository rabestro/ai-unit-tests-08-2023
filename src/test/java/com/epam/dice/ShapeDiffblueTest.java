package com.epam.dice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShapeDiffblueTest {
    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBeats() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Unknown shape: Shape
        //       at com.epam.dice.Shape.from(Shape.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Shape fromResult = Shape.from("Shape");
        Shape other = Shape.ROCK;

        // Act
        fromResult.beats(other);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats2() {
        // Arrange
        Shape shape = Shape.ROCK;
        Shape other = Shape.SCISSORS;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertTrue(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats3() {
        // Arrange
        Shape shape = Shape.ROCK;
        Shape other = Shape.ROCK;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertFalse(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats4() {
        // Arrange
        Shape shape = Shape.ROCK;
        Shape other = Shape.PAPER;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertFalse(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats5() {
        // Arrange
        Shape shape = Shape.PAPER;
        Shape other = Shape.SCISSORS;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertFalse(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats6() {
        // Arrange
        Shape shape = Shape.PAPER;
        Shape other = Shape.ROCK;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertTrue(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats7() {
        // Arrange
        Shape shape = Shape.SCISSORS;
        Shape other = Shape.SCISSORS;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertFalse(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#beats(Shape)}
     */
    @Test
    void testBeats8() {
        // Arrange
        Shape shape = Shape.SCISSORS;
        Shape other = Shape.PAPER;

        // Act
        boolean actualBeatsResult = shape.beats(other);

        // Assert
        assertTrue(actualBeatsResult);
    }

    /**
     * Method under test: {@link Shape#from(String)}
     */
    @Test
    void testFrom() {
        // Arrange
        String shape = "Shape";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Shape.from(shape));
    }

    /**
     * Method under test: {@link Shape#from(String)}
     */
    @Test
    void testFrom2() {
        // Arrange and Act
        Shape actualFromResult = Shape.from((String) "rock");

        // Assert
        assertEquals(Shape.ROCK, actualFromResult);
    }

    /**
     * Method under test: {@link Shape#from(String)}
     */
    @Test
    void testFrom3() {
        // Arrange and Act
        Shape actualFromResult = Shape.from((String) "paper");

        // Assert
        assertEquals(Shape.PAPER, actualFromResult);
    }

    /**
     * Method under test: {@link Shape#from(String)}
     */
    @Test
    void testFrom4() {
        // Arrange and Act
        Shape actualFromResult = Shape.from((String) "scissors");

        // Assert
        assertEquals(Shape.SCISSORS, actualFromResult);
    }
}
