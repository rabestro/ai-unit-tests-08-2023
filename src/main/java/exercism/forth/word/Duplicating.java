package exercism.forth.word;

import java.util.Deque;

public final class Duplicating implements ForthUnaryOperator {
    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        stack.push(stack.peek());
    }
}
