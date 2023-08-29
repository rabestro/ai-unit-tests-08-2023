package exercism.forth.word;

import java.util.Deque;

public final class Swapping implements ForthBinaryOperator {
    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a);
        stack.push(b);
    }
}
