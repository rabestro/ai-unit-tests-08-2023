package com.epam.flipflop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FlipFlopPredicateDiffblueTest {
    /**
     * Method under test: {@link FlipFlopPredicate#FlipFlopPredicate(Predicate, Predicate)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FlipFlopPredicate.lhs
        //     FlipFlopPredicate.rhs
        //     FlipFlopPredicate.state

        // Arrange
        Predicate<Object> lhs = mock(Predicate.class);
        Predicate<Object> rhs = mock(Predicate.class);

        // Act
        new FlipFlopPredicate<>(lhs, rhs);

    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest() {
        // Arrange
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(true);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";

        // Act
        boolean actualTestResult = flipFlopPredicate.test(string);

        // Assert
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest2() {
        // Arrange
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(false);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(true);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";

        // Act
        boolean actualTestResult = flipFlopPredicate.test(string);

        // Assert
        assertFalse(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest3() {
        // Arrange
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(false);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";

        // Act
        boolean actualTestResult = flipFlopPredicate.test(string);

        // Assert
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest4() {
        // Arrange
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(false);

        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        flipFlopPredicate.test(0);
        String string = "42";

        // Act
        boolean actualTestResult = flipFlopPredicate.test(string);

        // Assert
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs, atLeast(1)).test(Mockito.<Object>any());
    }
}
