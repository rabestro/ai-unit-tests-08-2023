package com.epam.chucknorris.encode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryToUnaryConverterDiffblueTest {
    /**
     * Method under test: {@link BinaryToUnaryConverter#apply(String)}
     */
    @Test
    void testApply() {
        // Arrange
        BinaryToUnaryConverter binaryToUnaryConverter = new BinaryToUnaryConverter();
        String binaryRepresentation = "Binary Representation";

        // Act
        String actualApplyResult = binaryToUnaryConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("", actualApplyResult);
    }

    /**
     * Method under test: {@link BinaryToUnaryConverter#apply(String)}
     */
    @Test
    void testApply2() {
        // Arrange
        BinaryToUnaryConverter binaryToUnaryConverter = new BinaryToUnaryConverter();
        String binaryRepresentation = "0";

        // Act
        String actualApplyResult = binaryToUnaryConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("00 0", actualApplyResult);
    }

    /**
     * Method under test: {@link BinaryToUnaryConverter#apply(String)}
     */
    @Test
    void testApply3() {
        // Arrange
        BinaryToUnaryConverter binaryToUnaryConverter = new BinaryToUnaryConverter();
        String binaryRepresentation = "0+|1+";

        // Act
        String actualApplyResult = binaryToUnaryConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("00 0 0 0", actualApplyResult);
    }

    /**
     * Method under test: {@link BinaryToUnaryConverter#convertBinaryToUnary(String)}
     */
    @Test
    void testConvertBinaryToUnary() {
        // Arrange
        BinaryToUnaryConverter binaryToUnaryConverter = new BinaryToUnaryConverter();
        String sequence = "Sequence";

        // Act
        String actualConvertBinaryToUnaryResult = binaryToUnaryConverter.convertBinaryToUnary(sequence);

        // Assert
        assertEquals("0 00000000", actualConvertBinaryToUnaryResult);
    }

    /**
     * Method under test: {@link BinaryToUnaryConverter#convertBinaryToUnary(String)}
     */
    @Test
    void testConvertBinaryToUnary2() {
        // Arrange
        BinaryToUnaryConverter binaryToUnaryConverter = new BinaryToUnaryConverter();
        String sequence = "0";

        // Act
        String actualConvertBinaryToUnaryResult = binaryToUnaryConverter.convertBinaryToUnary(sequence);

        // Assert
        assertEquals("00 0", actualConvertBinaryToUnaryResult);
    }
}
