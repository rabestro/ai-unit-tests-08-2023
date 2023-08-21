package hyperskill.mealplanner;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Ui extends Supplier<String>, Consumer<String> {

    static Ui of(Supplier<String> supplier, Consumer<? super String> consumer) {
        return new Ui() {
            @Override
            public String get() {
                return supplier.get();
            }

            @Override
            public void accept(String s) {
                consumer.accept(s);
            }
        };
    }

    static Ui console() {
        var scanner = new java.util.Scanner(System.in);
        return of(scanner::nextLine, System.out::println);
    }

    default String prompt(String message, Constraint constraint) {
        accept(message);
        while (true) {
            var input = get();
            if (constraint.test(input)) {
                return input;
            }
            accept(constraint.get());
        }
    }
}
