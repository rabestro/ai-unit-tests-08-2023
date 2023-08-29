package exercism.forth.word;

import java.util.Deque;

public final class Dropping implements ForthUnaryOperator {
    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        stack.pop();
    }
}
