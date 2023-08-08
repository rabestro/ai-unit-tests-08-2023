package com.epam.forth.word;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.forth.ForthCore;
import com.epam.forth.ForthStack;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DivisionDiffblueTest {
    /**
     * Method under test: {@link Division#accept(ForthStack)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Division requires that the stack contain at least 2 values
        //       at com.epam.forth.ForthCore.ensureSize(ForthCore.java:41)
        //       at com.epam.forth.word.Division.accept(Division.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Division division = new Division();
        ForthCore stack = new ForthCore();

        // Act
        division.accept(stack);
    }

    /**
     * Method under test: {@link Division#accept(ForthStack)}
     */
    @Test
    void testAccept2() {
        // Arrange
        Division division = new Division();
        ForthCore stack = mock(ForthCore.class);
        doNothing().when(stack).push(anyInt());
        when(stack.pop()).thenReturn(1);
        doNothing().when(stack).ensureSize(anyInt(), Mockito.<String>any());

        // Act
        division.accept(stack);

        // Assert that nothing has changed
        verify(stack, atLeast(1)).pop();
        verify(stack).ensureSize(anyInt(), Mockito.<String>any());
        verify(stack).push(anyInt());
    }

    /**
     * Method under test: {@link Division#accept(ForthStack)}
     */
    @Test
    void testAccept3() {
        // Arrange
        Division division = new Division();
        ForthCore stack = mock(ForthCore.class);
        doThrow(new IllegalArgumentException("Division requires that the stack contain at least 2 values")).when(stack)
                .push(anyInt());
        when(stack.pop()).thenReturn(1);
        doNothing().when(stack).ensureSize(anyInt(), Mockito.<String>any());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> division.accept(stack));
        verify(stack, atLeast(1)).pop();
        verify(stack).ensureSize(anyInt(), Mockito.<String>any());
        verify(stack).push(anyInt());
    }

    /**
     * Method under test: {@link Division#accept(ForthStack)}
     */
    @Test
    void testAccept4() {
        // Arrange
        Division division = new Division();
        ForthCore stack = mock(ForthCore.class);
        when(stack.pop()).thenReturn(0);
        doNothing().when(stack).ensureSize(anyInt(), Mockito.<String>any());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> division.accept(stack));
        verify(stack, atLeast(1)).pop();
        verify(stack).ensureSize(anyInt(), Mockito.<String>any());
    }
}
