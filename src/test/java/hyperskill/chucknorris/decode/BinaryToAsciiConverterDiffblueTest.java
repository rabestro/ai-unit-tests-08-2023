package hyperskill.chucknorris.decode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryToAsciiConverterDiffblueTest {
    /**
     * Method under test: {@link BinaryToAsciiConverter#apply(String)}
     */
    @Test
    void testApply() {
        // Arrange
        BinaryToAsciiConverter binaryToAsciiConverter = new BinaryToAsciiConverter();
        String binaryRepresentation = "Binary Representation";

        // Act
        String actualApplyResult = binaryToAsciiConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("", actualApplyResult);
    }

    /**
     * Method under test: {@link BinaryToAsciiConverter#apply(String)}
     */
    @Test
    void testApply2() {
        // Arrange
        BinaryToAsciiConverter binaryToAsciiConverter = new BinaryToAsciiConverter();
        String binaryRepresentation = "0000000";

        // Act
        String actualApplyResult = binaryToAsciiConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("\u0000", actualApplyResult);
    }

    /**
     * Method under test: {@link BinaryToAsciiConverter#apply(String)}
     */
    @Test
    void testApply3() {
        // Arrange
        BinaryToAsciiConverter binaryToAsciiConverter = new BinaryToAsciiConverter();
        String binaryRepresentation = "00000000000000";

        // Act
        String actualApplyResult = binaryToAsciiConverter.apply(binaryRepresentation);

        // Assert
        assertEquals("\u0000\u0000", actualApplyResult);
    }
}
