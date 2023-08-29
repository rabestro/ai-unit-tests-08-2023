package exercism.forth.word;

import java.util.Deque;

import static java.util.Objects.requireNonNull;

public final class Overing implements ForthBinaryOperator {
    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        int a = stack.pop();
        int b = requireNonNull(stack.peek());
        stack.push(a);
        stack.push(b);
    }
}
