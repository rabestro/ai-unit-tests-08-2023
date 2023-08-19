package com.epam.rockpaperscissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameWhiteBoxAiTest {
    private Consumer<String> outputMock;
    private Supplier<String> inputMock;

    @BeforeEach
    void setUp() {
        outputMock = mock(Consumer.class);
        inputMock = mock(Supplier.class);
    }

    @DisplayName("Testing the run method of Game")
    @Test
    void testGameRun() {
        var scoreBoardMock = mock(ScoreBoard.class);
        var game = new Game(inputMock, outputMock, scoreBoardMock);
        doReturn("!exit").when(inputMock).get();
        game.run();
        verify(outputMock).accept("Bye!");
    }

    @DisplayName("Testing oneRound method for user rating")
    @Test
    void testOneRoundUserRating() {
        var scoreBoardMock = mock(ScoreBoard.class);
        var game = new Game(inputMock, outputMock, scoreBoardMock);
        game.oneRound("!rating");
        verify(outputMock).accept("Your rating: " + game.rating);
    }

    @DisplayName("Testing oneRound method for invalid choice")
    @Test
    void testOneRoundInvalidChoice() {
        var shapesMock = mock(Shapes.class);
        var scoreBoardMock = mock(ScoreBoard.class);
        doReturn("invalid").when(inputMock).get();
        doReturn(false).when(shapesMock).contains(anyString());
        var game = new Game(inputMock, outputMock, scoreBoardMock);
        setField(game, "shapes", shapesMock);  // Use reflection to set the shapes object
        game.oneRound("invalid");
        verify(outputMock).accept("Invalid input");
    }

    @DisplayName("Initialize game")
    @Test
    void whenInitializeGameCalled_thenRequestAndDisplayUserNameAndInitializeShapes() {
        var scoreBoardMock = mock(ScoreBoard.class);
        var inputMock = mock(Supplier.class);
        var outputMock = mock(Consumer.class);
        var shapesMock = mock(Shapes.class);
        var game = new Game(inputMock, outputMock, scoreBoardMock);
        when(inputMock.get()).thenReturn("testUser").thenReturn("shape");
        when(scoreBoardMock.ratingOf("testUser")).thenReturn(100);
        setField(game, "shapes", shapesMock);

        game.initializeGame();

        verify(outputMock, times(3)).accept(anyString());
        verify(inputMock, times(2)).get();
        verify(scoreBoardMock).ratingOf("testUser");
    }

    @DisplayName("oneRound method plays round for valid choice")
    @Test
    void whenOneRoundCalledWithValidChoice_thenPlayRound() {
        var shapesMock = mock(Shapes.class);
        var scoreBoardMock = mock(ScoreBoard.class);
        var inputMock = mock(Supplier.class);
        var outputMock = mock(Consumer.class);
        var game = new Game(inputMock, outputMock, scoreBoardMock);

        when(shapesMock.contains("valid")).thenReturn(true);
        when(shapesMock.random()).thenReturn("rock");
        setField(game, "shapes", shapesMock);

        game.oneRound("valid");

        verify(outputMock).accept(anyString());
    }

    @ParameterizedTest(name = "[{index}] calculates the winner with ({0}, {1}, {2})")
    @CsvSource(delimiter = '|', textBlock = """
                draw            | 0 | There is a draw (%s)
                user won        | 1 | Well done. The computer chose %s and failed
                user lost       | 2 | Sorry, but the computer chose %s
            """)
    void testDetermineWinner(String scenario, int compareResult, String expectedResult) {
        var boardMock = mock(ScoreBoard.class);
        var game = new Game(inputMock, outputMock, boardMock);
        var shapesMock = mock(Shapes.class);
        when(shapesMock.compare(anyString(), anyString())).thenReturn(compareResult);
        setField(game, "shapes", shapesMock);

        var actualResult = game.determineWinner("rock", "paper");
        assertThat(actualResult)
                .as("Winner determination for scenario '%s' should result in: '%s'", scenario, expectedResult)
                .isEqualTo(expectedResult);
    }

    private void setField(Object targetObject, String fieldName, Object value) {
        try {
            var field = targetObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
