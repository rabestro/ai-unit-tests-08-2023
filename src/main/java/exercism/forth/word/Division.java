package exercism.forth.word;

import java.util.Deque;

public final class Division implements ForthBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        int divisor = stack.pop();
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
        int dividend = stack.pop();
        stack.push(dividend / divisor);
    }
}
