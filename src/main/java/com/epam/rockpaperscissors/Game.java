package com.epam.rockpaperscissors;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.function.Predicate.not;
import static java.util.stream.Stream.generate;

public final class Game implements Runnable {
    private static final int POINTS_PER_DRAW = 50;
    private static final int POINTS_PER_WIN = 100;
    private final Supplier<String> input;
    private final Consumer<? super String> output;
    private final ScoreBoard scoreBoard;
    private Shapes shapes;
    private int rating;

    public Game(Supplier<String> input, Consumer<? super String> output, ScoreBoard scoreBoard) {
        this.input = input;
        this.output = output;
        this.scoreBoard = scoreBoard;
    }

    @Override
    public void run() {
        initializeGame();
        generate(input)
                .takeWhile(not("!exit"::equals))
                .forEach(this::oneRound);
        output.accept("Bye!");
    }

    private void initializeGame() {
        output.accept("Enter your name:");
        var name = input.get();
        output.accept("Hello, " + name);
        rating = scoreBoard.ratingOf(name);
        shapes = new Shapes(input.get());
        output.accept("Okay, let's start");
    }

    private void oneRound(String userChoice) {
        if ("!rating".equals(userChoice)) {
            output.accept("Your rating: " + rating);
        } else if (shapes.contains(userChoice)) {
            playRound(userChoice);
        } else {
            output.accept("Invalid input");
        }
    }

    private void playRound(String userChoice) {
        var computer = shapes.random();
        var result = determineWinner(userChoice, computer)
                .formatted(computer.toLowerCase());
        output.accept(result);
    }

    private String determineWinner(String user, String computer) {
        switch (shapes.compare(user, computer)) {
            case 0:
                rating += POINTS_PER_DRAW;
                return "There is a draw (%s)";
            case 1:
                rating += POINTS_PER_WIN;
                return "Well done. The computer chose %s and failed";
            default:
                return "Sorry, but the computer chose %s";
        }
    }
}
