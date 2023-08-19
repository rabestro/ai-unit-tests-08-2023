package com.epam.rockpaperscissors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
public interface ScoreBoard extends Supplier<Map<String, Integer>> {

    static ScoreBoard empty() {
        var scores = new java.util.HashMap<String, Integer>();
        return () -> scores;
    }

    static ScoreBoard of(Path path) {
        try (var lines = Files.lines(path)) {
            var scores = lines
                    .map(ScoreBoard::parseScore)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            return () -> scores;
        } catch (IOException e) {
            return empty();
        }
    }

    private static Map.Entry<String, Integer> parseScore(String line) {
        var parts = line.split(" ");
        var name = parts[0];
        var value = Integer.parseInt(parts[1]);
        return new AbstractMap.SimpleEntry<>(name, value);
    }

    default int ratingOf(String name) {
        return get().getOrDefault(name, 0);
    }
}
