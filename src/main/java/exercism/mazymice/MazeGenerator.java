package exercism.mazymice;

public class MazeGenerator {

    public String generate(int rows, int columns) {
        return """
                ┌───────┬─┐
                │       │ │
                │ ┌─┬── │ │
                │ │ │   │ ⇨
                │ │ │ ──┤ │
                ⇨ │ │   │ │
                ┌─┤ └── │ │
                │ │     │ │
                │ │ ────┘ │
                │         │
                └─────────┘""";
    }

    public String generate(int rows, int columns, int seed) {
        return "";
    }
}
