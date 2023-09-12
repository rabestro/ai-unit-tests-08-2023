package com.epam.flipflop;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

/**
 * Emulates flip-flop logic similar to two-dots flip flop in Perl or Ruby.
 */
public final class FlipFlopPredicate<T> implements Predicate<T> {
    private final Predicate<? super T> startPredicate;
    private final Predicate<? super T> endPredicate;
    private boolean state;

    public FlipFlopPredicate(Predicate<? super T> lhs, Predicate<? super T> rhs) {
        this.startPredicate = requireNonNull(lhs);
        this.endPredicate = requireNonNull(rhs);
    }

    @Override
    public boolean test(final T value) {
        var result = state || startPredicate.test(value);
        state = result && !endPredicate.test(value);
        return result;
    }
}
