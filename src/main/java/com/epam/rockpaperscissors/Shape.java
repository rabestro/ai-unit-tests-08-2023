package com.epam.rockpaperscissors;

public enum Shape {
    ROCK, PAPER, SCISSORS;

    public boolean beats(Shape other) {
        return switch (this) {
            case ROCK -> other == SCISSORS;
            case PAPER -> other == ROCK;
            case SCISSORS -> other == PAPER;
        };
    }

    public static Shape fromString(String shape) {
        return switch (shape) {
            case "rock" -> ROCK;
            case "paper" -> PAPER;
            case "scissors" -> SCISSORS;
            default -> throw new IllegalArgumentException("Unknown shape: " + shape);
        };
    }
}
