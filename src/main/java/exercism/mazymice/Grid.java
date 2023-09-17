package exercism.mazymice;

import java.util.BitSet;
import java.util.EnumSet;
import java.util.Set;
import java.util.random.RandomGenerator;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

final class Grid {
    private final Dimension dimension;
    private final BitSet grid;
    private final RandomGenerator randomGenerator;

    Grid(Dimension dimension, RandomGenerator randomGenerator) {
        this.dimension = dimension;
        this.grid = new BitSet(dimension.width() * dimension.height());
        this.randomGenerator = randomGenerator;
    }

    Grid generateMaze() {
        generate(new Cell(1, 1));
        return this;
    }

    private int random(int bound) {
        return randomGenerator.nextInt(bound);
    }

    private Direction pickRandomDirection(Set<Direction> directions) {
        int size = directions.size();
        int itemIndex = random(size);
        var direction = directions.toArray(new Direction[size])[itemIndex];
        directions.remove(direction);
        return direction;
    }

    Grid placeDoors() {
        new Cell(1 + 2 * random(dimension.rows()), 0).erase();
        new Cell(1 + 2 * random(dimension.rows()), dimension.width() - 1).erase();
        return this;
    }

    private void generate(Cell cell) {
        cell.erase();

        var directions = EnumSet.allOf(Direction.class);
        do {
            var direction = pickRandomDirection(directions);
            var wall = cell.move(direction);
            var next = wall.move(direction);
            if (next.isValid() && next.isNotEmpty()) {
                wall.erase();
                generate(next);
            }
        } while (!directions.isEmpty());
    }

    char[][] print() {
        return range(0, dimension.height())
                .mapToObj(this::line)
                .toArray(char[][]::new);
    }

    private char[] line(int x) {
        return range(0, dimension.width())
                .map(y -> new Cell(x, y).symbol())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .toCharArray();
    }

    private StringBuilder printLine(int x) {
        var sb = new StringBuilder(dimension.width() + 1);
        range(0, dimension.width())
                .map(y -> new Cell(x, y).symbol())
                .forEach(sb::appendCodePoint);
        return sb.append(System.lineSeparator());
    }

    private final class Cell {
        final int x;
        final int y;

        private Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValid() {
            return x > 0 && x < dimension.height() && y > 0 && y < dimension.width();
        }

        void erase() {
            grid.set(index());
        }

        boolean isNotEmpty() {
            return !isEmpty();
        }

        boolean isEmpty() {
            return grid.get(index());
        }

        int index() {
            return x * dimension.width() + y;
        }

        boolean isDoor() {
            return isEmpty() && (y == 0 || y == dimension.width() - 1);
        }

        Cell move(Direction direction) {
            return switch (direction) {
                case NORTH -> new Cell(x, y - 1);
                case EAST -> new Cell(x + 1, y);
                case SOUTH -> new Cell(x, y + 1);
                case WEST -> new Cell(x - 1, y);
            };
        }

        Character symbol() {
            if (isDoor()) {
                return '⇨';
            }
            if (isEmpty()) {
                return ' ';
            }
            var n = x > 0 && new Cell(x - 1, y).isNotEmpty() ? 1 : 0;
            var e = y < dimension.width() - 1 && new Cell(x, y + 1).isNotEmpty() ? 1 : 0;
            var s = x < dimension.height() - 1 && new Cell(x + 1, y).isNotEmpty() ? 1 : 0;
            var w = y > 0 && new Cell(x, y - 1).isNotEmpty() ? 1 : 0;
            var i = n + 2 * e + 4 * s + 8 * w;
            return switch (i) {
                case 0 -> ' ';
                case 1, 5, 4 -> '│';
                case 2, 8, 10 -> '─';
                case 3 -> '└';
                case 6 -> '┌';
                case 7 -> '├';
                case 9 -> '┘';
                case 11 -> '┴';
                case 12 -> '┐';
                case 13 -> '┤';
                case 14 -> '┬';
                case 15 -> '┼';
                default -> throw new IllegalStateException("Unexpected value: " + i);
            };
        }
    }
}
