package com.epam.rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShapesDiffblueTest {
    /**
     * Method under test: {@link Shapes#Shapes(String)}
     */
    @Test
    void testConstructor() {
        // Arrange
        String options = "Options";

        // Act
        Shapes actualShapes = new Shapes(options);

        // Assert
        assertEquals("Options", actualShapes.random());
    }

    /**
     * Method under test: {@link Shapes#contains(String)}
     */
    @Test
    void testContains() {
        // Arrange
        Shapes shapes = new Shapes("Options");
        String shape = "Shape";

        // Act
        boolean actualContainsResult = shapes.contains(shape);

        // Assert
        assertFalse(actualContainsResult);
    }

    /**
     * Method under test: {@link Shapes#contains(String)}
     */
    @Test
    void testContains2() {
        // Arrange
        Shapes shapes = new Shapes("42");
        String shape = "42";

        // Act
        boolean actualContainsResult = shapes.contains(shape);

        // Assert
        assertTrue(actualContainsResult);
    }

    /**
     * Method under test: {@link Shapes#random()}
     */
    @Test
    void testRandom() {
        // Arrange
        Shapes shapes = new Shapes("Options");

        // Act
        String actualRandomResult = shapes.random();

        // Assert
        assertEquals("Options", actualRandomResult);
    }

    /**
     * Method under test: {@link Shapes#random()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRandom2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at java.base/java.util.ImmutableCollections$ListN.get(ImmutableCollections.java:680)
        //       at com.epam.rockpaperscissors.Shapes.random(Shapes.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Shapes shapes = new Shapes(",");

        // Act
        shapes.random();
    }

    /**
     * Method under test: {@link Shapes#compare(String, String)}
     */
    @Test
    void testCompare() {
        // Arrange
        Shapes shapes = new Shapes("Options");
        String first = "First";
        String second = "Second";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> shapes.compare(first, second));
    }

    /**
     * Method under test: {@link Shapes#compare(String, String)}
     */
    @Test
    void testCompare2() {
        // Arrange
        Shapes shapes = new Shapes("42");
        String first = "42";
        String second = "Second";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> shapes.compare(first, second));
    }

    /**
     * Method under test: {@link Shapes#compare(String, String)}
     */
    @Test
    void testCompare3() {
        // Arrange
        Shapes shapes = new Shapes("42");
        String first = "42";
        String second = "42";

        // Act
        int actualCompareResult = shapes.compare(first, second);

        // Assert
        assertEquals(0, actualCompareResult);
    }

    /**
     * Method under test: {@link Shapes#compare(String, String)}
     */
    @Test
    void testCompare4() {
        // Arrange
        Shapes shapes = new Shapes(",42");
        String first = "";
        String second = "42";

        // Act
        int actualCompareResult = shapes.compare(first, second);

        // Assert
        assertEquals(1, actualCompareResult);
    }
}
