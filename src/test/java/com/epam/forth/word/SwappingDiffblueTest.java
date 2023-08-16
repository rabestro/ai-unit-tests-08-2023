package com.epam.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SwappingDiffblueTest {
    /**
     * Method under test: {@link Swapping#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Swapping requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Swapping.accept(Swapping.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Swapping swapping = new Swapping();
        LinkedList<Integer> stack = new LinkedList<>();

        // Act
        swapping.accept(stack);
    }

    /**
     * Method under test: {@link Swapping#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Swapping requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Swapping.accept(Swapping.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Swapping swapping = new Swapping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);

        // Act
        swapping.accept(stack);
    }

    /**
     * Method under test: {@link Swapping#accept(Deque)}
     */
    @Test
    void testAccept3() {
        // Arrange
        Swapping swapping = new Swapping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);

        // Act
        swapping.accept(stack);

        // Assert
        assertEquals(2, stack.size());
        assertEquals(2, stack.get(0));
        assertEquals(1, stack.get(1));
    }
}
