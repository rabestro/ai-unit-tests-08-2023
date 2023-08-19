package com.epam.rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ScoreBoardDiffblueTest {
    /**
     * Method under test: {@link ScoreBoard#empty()}
     */
    @Test
    void testEmpty() {
        // Arrange and Act
        Map<String, Integer> actualGetResult = ScoreBoard.empty().get();

        // Assert
        assertTrue(actualGetResult.isEmpty());
    }

    /**
     * Method under test: {@link ScoreBoard#of(Path)}
     */
    @Test
    void testOf() {
        // Arrange
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

        // Act
        Map<String, Integer> actualGetResult = ScoreBoard.of(path).get();

        // Assert
        assertTrue(actualGetResult.isEmpty());
    }
}
