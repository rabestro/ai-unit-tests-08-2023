package hyperskill.chucknorris.encode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
