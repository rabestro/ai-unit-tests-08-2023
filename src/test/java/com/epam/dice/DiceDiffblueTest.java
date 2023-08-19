package com.epam.dice;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DiceDiffblueTest {
    /**
     * Method under test: {@link Dice#of(int)}
     */
    @Test
    void testOf() {
        // Arrange
        int sides = 1;

        // Act
        int actualRollResult = Dice.of(sides).roll();

        // Assert
        assertEquals(1, actualRollResult);
    }

    /**
     * Method under test: {@link Dice#of(int, RandomGenerator)}
     */
    @Test
    void testOf2() {
        // Arrange
        int sides = 1;
        RandomGenerator randomGenerator = mock(RandomGenerator.class);
        when(randomGenerator.nextInt(anyInt())).thenReturn(1);

        // Act
        int actualRollResult = Dice.of(sides, randomGenerator).roll();

        // Assert
        verify(randomGenerator).nextInt(anyInt());
        assertEquals(2, actualRollResult);
    }

    /**
     * Method under test: {@link Dice#of(int, RandomGenerator)}
     */
    @Test
    void testOf3() {
        // Arrange
        int sides = 1;
        RandomGenerator randomGenerator = mock(RandomGenerator.class);
        when(randomGenerator.nextInt(anyInt())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Dice.of(sides, randomGenerator).roll());
        verify(randomGenerator).nextInt(anyInt());
    }
}
