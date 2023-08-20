package com.epam.forth;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForthEngineDiffblueTest {
    /**
     * Method under test: default or parameterless constructor of {@link ForthEngine}
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        ForthEngine actualForthEngine = new ForthEngine();

        // Assert
        assertTrue(actualForthEngine.get().isEmpty());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept() {
        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = "Command";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at java.base/java.util.Arrays$ArrayList.get(Arrays.java:4165)
        //       at com.epam.forth.ForthEngine.isWordDefinition(ForthEngine.java:49)
        //       at com.epam.forth.ForthEngine.accept(ForthEngine.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = " ";

        // Act
        forthEngine.accept(command);
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
        //       at java.base/java.util.Arrays$ArrayList.get(Arrays.java:4165)
        //       at com.epam.forth.ForthEngine.defineWord(ForthEngine.java:53)
        //       at com.epam.forth.ForthEngine.accept(ForthEngine.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = ":";

        // Act
        forthEngine.accept(command);
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept4() {
        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = "42";

        // Act
        forthEngine.accept(command);

        // Assert
        assertEquals(1, forthEngine.get().size());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccept5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: fromIndex(2) > toIndex(1)
        //       at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
        //       at java.base/java.util.AbstractList.subList(AbstractList.java:497)
        //       at com.epam.forth.ForthEngine.defineWord(ForthEngine.java:54)
        //       at com.epam.forth.ForthEngine.accept(ForthEngine.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = ": :";

        // Act
        forthEngine.accept(command);
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept6() {
        // Arrange
        ForthEngine forthEngine = new ForthEngine();
        String command = ": 42";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
    }

    /**
     * Method under test: {@link ForthEngine#get()}
     */
    @Test
    void testGet() {
        // Arrange
        ForthEngine forthEngine = new ForthEngine();

        // Act
        List<Integer> actualGetResult = forthEngine.get();

        // Assert
        assertTrue(actualGetResult.isEmpty());
    }
}
