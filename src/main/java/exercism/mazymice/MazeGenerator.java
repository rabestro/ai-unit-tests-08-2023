package exercism.mazymice;

import java.util.Random;
import java.util.random.RandomGenerator;

public final class MazeGenerator {

    public String generatePerfectMaze(Dimension dimension) {
        return new Grid(dimension, RandomGenerator.getDefault())
                .generateMaze()
                .placeDoors()
                .print();
    }

    public String generatePerfectMaze(Dimension dimension, int seed) {
        return new Grid(dimension, new Random(seed))
                .generateMaze()
                .placeDoors()
                .print();
    }
}
