package com.epam.forth.word;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.forth.ForthCore;
import com.epam.forth.ForthStack;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AdditionDiffblueTest {
    /**
     * Method under test: {@link Addition#accept(ForthStack)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Addition requires that the stack contain at least 2 values
        //       at com.epam.forth.ForthCore.ensureSize(ForthCore.java:41)
        //       at com.epam.forth.word.Addition.accept(Addition.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Addition addition = new Addition();
        ForthCore stack = new ForthCore();

        // Act
        addition.accept(stack);
    }

    /**
     * Method under test: {@link Addition#accept(ForthStack)}
     */
    @Test
    void testAccept2() {
        // Arrange
        Addition addition = new Addition();
        ForthCore stack = mock(ForthCore.class);
        when(stack.pop()).thenReturn(1);
        doNothing().when(stack).ensureSize(anyInt(), Mockito.<String>any());
        doNothing().when(stack).push(anyInt());

        // Act
        addition.accept(stack);

        // Assert that nothing has changed
        verify(stack, atLeast(1)).pop();
        verify(stack).ensureSize(anyInt(), Mockito.<String>any());
        verify(stack).push(anyInt());
    }
}
