package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.models.Error;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposalViewTest {

    @Mock
    ProposalController proposalController;

    @Mock
    Console console;

    @InjectMocks
    ProposalView proposalView;

    @Test
    void testGiven1AttemptAndIsWinnerGameWhenInteractThenReturnsTrue() {
        try(MockedStatic console = mockStatic(Console.class)){
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.proposalController.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(true);

            assertThat(this.proposalView.interact(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try(MockedStatic console = mockStatic(Console.class)){
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.proposalController.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(false);
            when(this.proposalController.isLooser()).thenReturn(false);

            assertThat(this.proposalView.interact(), is(false));
        }
    }

    @Test
    void testGivenSomeBadProposedCombinationWhenCorrectOneIsGivenThenInteractFinish() {
        try(MockedStatic console = mockStatic(Console.class)){
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString()))
                    .thenReturn("rgbyo", "rgby");
            when(this.proposalController.addProposedCombination(any()))
                    .thenReturn(Error.WRONG_LENGTH, Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(true);

            assertThat(this.proposalView.interact(), is(true));
            verify(this.console).writeln("Wrong proposed combination length");

        }
    }
}
