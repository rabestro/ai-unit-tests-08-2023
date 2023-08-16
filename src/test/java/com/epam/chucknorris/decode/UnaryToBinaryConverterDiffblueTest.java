package com.epam.chucknorris.decode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnaryToBinaryConverterDiffblueTest {
    /**
     * Method under test: {@link UnaryToBinaryConverter#apply(String)}
     */
    @Test
    void testApply() {
        // Arrange
        UnaryToBinaryConverter unaryToBinaryConverter = new UnaryToBinaryConverter();
        String unaryRepresentation = "Unary Representation";

        // Act
        String actualApplyResult = unaryToBinaryConverter.apply(unaryRepresentation);

        // Assert
        assertEquals("", actualApplyResult);
    }

    /**
     * Method under test: {@link UnaryToBinaryConverter#apply(String)}
     */
    @Test
    void testApply2() {
        // Arrange
        UnaryToBinaryConverter unaryToBinaryConverter = new UnaryToBinaryConverter();
        String unaryRepresentation = "0 0";

        // Act
        String actualApplyResult = unaryToBinaryConverter.apply(unaryRepresentation);

        // Assert
        assertEquals("1", actualApplyResult);
    }

    /**
     * Method under test: {@link UnaryToBinaryConverter#apply(String)}
     */
    @Test
    void testApply3() {
        // Arrange
        UnaryToBinaryConverter unaryToBinaryConverter = new UnaryToBinaryConverter();
        String unaryRepresentation = "00 0";

        // Act
        String actualApplyResult = unaryToBinaryConverter.apply(unaryRepresentation);

        // Assert
        assertEquals("0", actualApplyResult);
    }

    /**
     * Method under test: {@link UnaryToBinaryConverter#apply(String)}
     */
    @Test
    void testApply4() {
        // Arrange
        UnaryToBinaryConverter unaryToBinaryConverter = new UnaryToBinaryConverter();
        String unaryRepresentation = "0 00 00 0";

        // Act
        String actualApplyResult = unaryToBinaryConverter.apply(unaryRepresentation);

        // Assert
        assertEquals("110", actualApplyResult);
    }
}
