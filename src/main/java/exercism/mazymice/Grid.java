package exercism.mazymice;

import java.util.BitSet;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

final class Grid {
    private final int rows;
    private final int width;
    private final int height;
    private final BitSet grid;

    Grid(int rows, int columns) {
        this.rows = rows;
        this.width = 2 * columns + 1;
        this.height = 2 * rows + 1;
        this.grid = new BitSet(width * height);
    }

    Grid generateMaze() {
        generate(new Cell(1, 1));
        return this;
    }

    private int random(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    private Direction pickRandomDirection(Set<Direction> directions) {
        int size = directions.size();
        int itemIndex = random(size);
        var direction = directions.toArray(new Direction[size])[itemIndex];
        directions.remove(direction);
        return direction;
    }

    Grid placeDoors() {
        new Cell(1 + 2 * random(rows), 0).erase();
        new Cell(1 + 2 * random(rows), width - 1).erase();
        return this;
    }

    private void generate(Cell cell) {
        cell.erase();

        var directions = EnumSet.allOf(Direction.class);
        do {
            var direction = pickRandomDirection(directions);

            var delta = switch (direction) {
                case NORTH -> new Cell(0, -1);
                case EAST -> new Cell(1, 0);
                case SOUTH -> new Cell(0, 1);
                case WEST -> new Cell(-1, 0);
            };
            var wall = cell.add(delta);
            var next = wall.add(delta);
            if (next.isValid() && next.isNotEmpty()) {
                wall.erase();
                generate(next);
            }
        } while (!directions.isEmpty());
    }


    private final class Cell {
        final int x;
        final int y;

        private Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Cell add(Cell delta) {
            return new Cell(x + delta.x, y + delta.y);
        }

        boolean isValid() {
            return x > 0 && x < height && y > 0 && y < width;
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
            return x * width + y;
        }

        boolean isDoor() {
            return isEmpty() && (x == 0 || x == width - 1);
        }

        char symbol() {
            if (isEmpty()) {
                return ' ';
            }
            if (isDoor()) {
                return '⇨';
            }
            return '#';
        }
    }
}
    /*
    function symbol(row, col,   n,e,s,w) {
    if (!Grid[row, col]) return " "
    if (is_door(row, col)) return "⇨"
    n = row ? Grid[row - 1, col] : 0
    e = col < Width - 1 ? Grid[row, col + 1] : 0
    s = row < Height - 1 ? Grid[row + 1, col] : 0
    w = col ? Grid[row, col - 1] : 0
    return substr(" │─└││┌├─┘─┴┐┤┬┼", 1 + n + 2 * e + 4 * s + 8 * w, 1)
}

function is_door(row, col) {return row == MazeEntrance && col == 0 || row == MazeExit && col == Width - 1}

     */