package exercism.forth.word;

@FunctionalInterface
public interface ForthUnaryOperator extends ForthWord {
    @Override
    default int requiredStackSize() {
        return 1;
    }
}
