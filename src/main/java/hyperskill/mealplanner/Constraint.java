package hyperskill.mealplanner;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Constraint extends Predicate<String>, Supplier<String> {

    static Constraint of(Predicate<? super String> predicate, String message) {
        return new Constraint() {
            @Override
            public boolean test(String input) {
                return predicate.test(input);
            }

            @Override
            public String get() {
                return message;
            }
        };
    }

    static Constraint category() {
        return of(s -> s.matches("breakfast|lunch|dinner"),
                "Wrong meal category! Choose from: breakfast, lunch, dinner.");
    }

    static Constraint name() {
        return of(Predicate.not(String::isBlank).and(s -> s.matches("[a-zA-Z ]+")),
                "Wrong format. Use letters only!");
    }

    static Constraint ingredients() {
        return of(Predicate.not(String::isBlank).and(s -> s.matches("(?i)[a-z ]+(, ?[a-z][a-z ]*)*")),
                "Wrong format. Use letters only!");
    }
}
