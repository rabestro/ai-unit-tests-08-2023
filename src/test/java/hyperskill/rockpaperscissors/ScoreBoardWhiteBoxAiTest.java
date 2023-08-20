package hyperskill.rockpaperscissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardWhiteBoxAiTest {

    @TempDir
    Path tempDirectory;

    static Stream<Arguments> fileAndScoreProvider() {
        Map<String, Integer> expectedOfExist = Map.of("player1", 10, "player2", 5);
        Map<String, Integer> expectedOfEmpty = Map.of();
        return Stream.of(
                Arguments.of("ofExist.txt", expectedOfExist),
                Arguments.of("ofEmpty.txt", expectedOfEmpty)
        );
    }

    @BeforeEach
    void setupFiles() throws IOException {
        var ofExist = Files.createFile(tempDirectory.resolve("ofExist.txt"));
        Files.writeString(ofExist, "player1 10\nplayer2 5");
        var ofEmpty = Files.createFile(tempDirectory.resolve("ofEmpty.txt"));
        Files.writeString(ofEmpty, "");
    }

    @DisplayName("Test empty()")
    @Test
    void testEmpty() {
        var scoreboard = ScoreBoard.empty();
        assertThat(scoreboard.get())
                .as("Expected scoreboard to be empty")
                .isEmpty();
    }

    @DisplayName("Parse files and return scoreboard")
    @ParameterizedTest(name = "[{index}] Parse {0} and return scoreboard: {1}")
    @MethodSource("fileAndScoreProvider")
    void testOf(String fileName, Map<String, Integer> expectedResult) {
        var path = tempDirectory.resolve(fileName);
        var scoreboard = ScoreBoard.of(path);
        assertThat(scoreboard.get())
                .as("Mismatch in expected and actual scores for file " + fileName)
                .isEqualTo(expectedResult);
    }

    @DisplayName("Get player rating")
    @ParameterizedTest(name = "[{index}] get player {0} rating: {1}")
    @CsvSource({
            "'player1',   10",
            "'player2',   5",
            "'nonExist',  0",
    })
    void testRatingOf(String name, int expectedRating) {
        var initialScores = Map.of("player1", 10, "player2", 5);
        ScoreBoard scoreboard = () -> initialScores;
        var actualRating = scoreboard.ratingOf(name);
        assertThat(actualRating)
                .as("The rating for player %s should be %d", name, expectedRating)
                .isEqualTo(expectedRating);
    }
}
