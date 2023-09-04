package com.epam.flipflop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlipFlopPredicateDiffblueTest {
    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest() {
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(true);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";
        boolean actualTestResult = flipFlopPredicate.test(string);
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest2() {
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(false);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(true);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";
        boolean actualTestResult = flipFlopPredicate.test(string);
        assertFalse(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest3() {
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(false);
        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        String string = "Value";
        boolean actualTestResult = flipFlopPredicate.test(string);
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs).test(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FlipFlopPredicate#test(Object)}
     */
    @Test
    void testTest4() {
        Predicate<Object> lhs = mock(Predicate.class);
        when(lhs.test(Mockito.<Object>any())).thenReturn(true);
        Predicate<Object> rhs = mock(Predicate.class);
        when(rhs.test(Mockito.<Object>any())).thenReturn(false);

        FlipFlopPredicate<Object> flipFlopPredicate = new FlipFlopPredicate<>(lhs, rhs);
        flipFlopPredicate.test(0);
        String string = "42";
        boolean actualTestResult = flipFlopPredicate.test(string);
        assertTrue(actualTestResult);
        verify(lhs).test(Mockito.<Object>any());
        verify(rhs, atLeast(1)).test(Mockito.<Object>any());
    }
}
