package com.epam.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DivisionDiffblueTest {
    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Division requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Division.accept(Division.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Division division = new Division();
        LinkedList<Integer> stack = new LinkedList<>();

        // Act
        division.accept(stack);
    }

    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Division requires that the stack contain at least 2 values
        //       at com.epam.forth.word.ForthWord.ensureSize(ForthWord.java:17)
        //       at com.epam.forth.word.Division.accept(Division.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);

        // Act
        division.accept(stack);
    }

    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    void testAccept3() {
        // Arrange
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);

        // Act
        division.accept(stack);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(2, stack.get(0));
    }

    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    void testAccept4() {
        // Arrange
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> division.accept(stack));
    }

    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    void testAccept5() {
        // Arrange
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);
        stack.add(1);
        stack.add(2);

        // Act
        division.accept(stack);

        // Assert
        assertEquals(2, stack.size());
        assertEquals(0, stack.get(0));
        assertEquals(2, stack.get(1));
    }
}
