package com.epam.chucknorris.encode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AsciiToBinaryConverterDiffblueTest {
    /**
     * Method under test: {@link AsciiToBinaryConverter#apply(String)}
     */
    @Test
    void testApply() {
        // Arrange
        AsciiToBinaryConverter asciiToBinaryConverter = new AsciiToBinaryConverter();
        String text = "Text";

        // Act
        String actualApplyResult = asciiToBinaryConverter.apply(text);

        // Assert
        assertEquals("1010100110010111110001110100", actualApplyResult);
    }

    /**
     * Method under test: {@link AsciiToBinaryConverter#apply(String)}
     */
    @Test
    void testApply2() {
        // Arrange
        AsciiToBinaryConverter asciiToBinaryConverter = new AsciiToBinaryConverter();
        String text = "";

        // Act
        String actualApplyResult = asciiToBinaryConverter.apply(text);

        // Assert
        assertEquals("", actualApplyResult);
    }

    /**
     * Method under test: {@link AsciiToBinaryConverter#charToBinary(int)}
     */
    @Test
    void testCharToBinary() {
        // Arrange
        AsciiToBinaryConverter asciiToBinaryConverter = new AsciiToBinaryConverter();
        int value = 42;

        // Act
        String actualCharToBinaryResult = asciiToBinaryConverter.charToBinary(value);

        // Assert
        assertEquals("0101010", actualCharToBinaryResult);
    }
}
