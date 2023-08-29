package exercism.forth.word;


import java.util.Collection;
import java.util.Deque;
import java.util.Map;
import java.util.function.Consumer;

@FunctionalInterface
public interface ForthWord extends Consumer<Deque<Integer>> {

    static Map<String, ForthWord> builtInWords() {
        return Map.of(
                "+", new Addition(),
                "-", new Subtraction(),
                "*", new Multiplication(),
                "/", new Division(),
                "dup", new Duplicating(),
                "drop", new Dropping(),
                "swap", new Swapping(),
                "over", new Overing()
        );
    }

    static ForthWord number(String token) {
        return stack -> stack.push(Integer.parseInt(token));
    }

    default int requiredStackSize() {
        return 0;
    }

    default void ensureSize(Collection<Integer> stack) {
        if (stack.size() < requiredStackSize()) {
            throw new IllegalStateException(errorMessage());
        }
    }

    private String errorMessage() {
        return this.getClass().getSimpleName()
               + " requires that the stack contain at least "
               + this.requiredStackSize()
               + (this.requiredStackSize() == 1 ? " value" : " values");
    }
}
