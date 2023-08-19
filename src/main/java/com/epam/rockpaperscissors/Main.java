package com.epam.rockpaperscissors;

import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) {
        var scores = ScoreBoard.of(Path.of("rating.txt"));
        var scanner = new java.util.Scanner(System.in);
        new Game(scanner::nextLine, System.out::println, scores).run();
    }
}
