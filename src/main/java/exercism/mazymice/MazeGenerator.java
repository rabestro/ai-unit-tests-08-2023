package exercism.mazymice;

import java.util.Random;
import java.util.random.RandomGenerator;

public final class MazeGenerator {

    public char[][] generatePerfectMaze(Dimensions dimensions) {
        return new Grid(dimensions, RandomGenerator.getDefault())
                .generateMaze()
                .placeDoors()
                .print();
    }

    public char[][] generatePerfectMaze(Dimensions dimensions, int seed) {
        return new Grid(dimensions, new Random(seed))
                .generateMaze()
                .placeDoors()
                .print();
    }
}
