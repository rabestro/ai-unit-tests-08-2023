package com.epam.flipflop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipFlopPredicateAiTest {

    @DisplayName("Example 1 - filtering B to G")
    @Test
    void testFilteringBToG() {
        Predicate<String> start = element -> element.equals("B");
        Predicate<String> end = element -> element.equals("G");
        FlipFlopPredicate<String> flipFlopPredicate = new FlipFlopPredicate<>(start, end);

        List<String> input = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        List<String> result = input.stream().filter(flipFlopPredicate).collect(Collectors.toList());
        assertEquals(List.of("B", "C", "D", "E", "F", "G"), result);
    }

    @DisplayName("Example 2 - filtering divisibles by 3 and 5")
    @Test
    void testFilteringDivisibleByThreeAndFive() {
        Predicate<Integer> start = x -> x % 3 == 0;
        Predicate<Integer> end = x -> x % 5 == 0;
        FlipFlopPredicate<Integer> flipFlopPredicate = new FlipFlopPredicate<>(start, end);

        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 19);
        List<Integer> result = input.stream().filter(flipFlopPredicate).collect(Collectors.toList());
        assertEquals(List.of(3, 4, 5, 6, 7, 8, 9, 10, 15, 18, 19), result);
    }

    @DisplayName("Test with no matching start/end predicates")
    @Test
    void testWithNoMatchingPredicates() {
        Predicate<String> start = element -> element.equals("X");
        Predicate<String> end = element -> element.equals("Y");
        FlipFlopPredicate<String> flipFlopPredicate = new FlipFlopPredicate<>(start, end);

        List<String> input = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        List<String> result = input.stream().filter(flipFlopPredicate).collect(Collectors.toList());
        assertEquals(List.of(), result);
    }

}
