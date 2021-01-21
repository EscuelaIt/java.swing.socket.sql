package usantatecla.mastermind.views;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {
/*
    @Mock
    Game game;

    @Mock
    ProposedCombination proposedCombination;

    @Mock
    Result result;

    @Mock
    Console console;

    @InjectMocks
    BoardView boardView;

    @Test
    void testGivenWinGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(true);
        assertThat(this.boardView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenLooseGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(true);
        assertThat(this.boardView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenNotLooseNorWinGameWhenIsWinnerOrLooserThenReturnsFalse() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(false);
        assertThat(this.boardView.isWinnerOrLooser(), is(false));
    }

    @Test
    void testGivenEmptyGameStateWhenWriteThenOnlySecretCombinationIsWritten() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.getAttempts()).thenReturn(0);
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write();
            verify(this.console, times(2)).writeln();
            verify(this.console, times(4)).write("*");
        }
    }

    @Test
    void testGiven2AttemptsGameStateWhenWriteThenCorrectArgumentsAreCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.getAttempts()).thenReturn(2);
            when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
            when(this.game.getResult(anyInt())).thenReturn(this.result);
            when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.ORANGE, Color.YELLOW));
            when(this.result.getBlacks()).thenReturn(0);
            when(this.result.getWhites()).thenReturn(0);
            ArgumentCaptor<String> secretCombination = ArgumentCaptor.forClass(String.class);
            ArgumentCaptor<String> proposedCombination = ArgumentCaptor.forClass(String.class);
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write();
            verify(this.console, times(3)).writeln(secretCombination.capture());
            verify(this.console, times(12)).write(proposedCombination.capture());
            assertThat(secretCombination.getAllValues().get(0), is("2 attempt(s): "));
            assertThat(proposedCombination.getAllValues().toString(),
                    is("[*, *, *, *, " + "\u001B[31m" + "r" + "\u001B[0m, " +
                            "\u001B[32m" + "g" + "\u001B[0m, " +
                            "\u001B[37m" + "o" + "\u001B[0m, " +
                            "\u001B[33m" + "y" + "\u001B[0m, " +
                            "\u001B[31m" + "r" + "\u001B[0m, " +
                            "\u001B[32m" + "g" + "\u001B[0m, " +
                            "\u001B[37m" + "o" + "\u001B[0m, " +
                            "\u001B[33m" + "y" + "\u001B[0m]"));
        }
    }*/

    /*@Test
    public void testGivenBoardWhenResetThenEmpty() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Board board = new BoardBuilder().build();
            board.reset();
            board.write();
            verify(this.console).writeln("0 attempt(s): ");
        }
    }*/

    /*@Test
    public void testGivenBoardWhenWriteThenPrint() {
        String colors = "rgby";
        Board board = new BoardBuilder().proposedCombinations(2, colors).build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            verify(this.console).writeln("2 attempt(s): ");
            verify(this.console).writeln(Message.SECRET_COMBINATION.toString());
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(colors)) {
                verify(this.console, times(2)).write(colorCode.get() + colorCode.getInitial() + ColorCode.RESET_COLOR.get());
            }
        }
    }*/
}