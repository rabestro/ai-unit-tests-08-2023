package com.epam.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AdditionDiffblueTest {
    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Addition requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Addition.accept(Addition.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Addition addition = new Addition();
        LinkedList<Integer> stack = new LinkedList<>();

        // Act
        addition.accept(stack);
    }

    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Addition requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Addition.accept(Addition.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Addition addition = new Addition();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);

        // Act
        addition.accept(stack);
    }

    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    void testAccept3() {
        // Arrange
        Addition addition = new Addition();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);

        // Act
        addition.accept(stack);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(3, stack.get(0));
    }

    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    void testAccept4() {
        // Arrange
        Addition addition = new Addition();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);

        // Act
        addition.accept(stack);

        // Assert
        assertEquals(2, stack.size());
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
    }
}
