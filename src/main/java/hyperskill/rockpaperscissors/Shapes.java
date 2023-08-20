package hyperskill.rockpaperscissors;

import java.util.List;

public final class Shapes {
    private final List<String> shapes;

    public Shapes(String options) {
        shapes = options.isBlank()
                ? List.of("rock", "paper", "scissors")
                : List.of(options.split(","));
    }

    public boolean contains(String shape) {
        return shapes.contains(shape);
    }

    public String random() {
        var index = (int) (Math.random() * shapes.size());
        return shapes.get(index);
    }

    int compare(String first, String second) {
        if (!shapes.contains(first) || !shapes.contains(second)) {
            throw new IllegalArgumentException("Invalid shapes");
        }
        if (first.equals(second)) {
            return 0;
        }
        var length = shapes.size();
        var half = length / 2;
        var firstIndex = shapes.indexOf(first);
        var delta = half - firstIndex;
        firstIndex = (firstIndex + delta) % length;
        var secondIndex = (shapes.indexOf(second) + delta) % length;
        return Integer.compare(firstIndex, secondIndex);
    }
}
