package usantatecla.utils;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class SquaredBoundedCoordinateTest {

    private static final int DIMENSION = 7;
    private static final String ERROR = "error";

    public SquaredBoundedCoordinate getNullCoordinate() {
        return new SquaredBoundedCoordinate() {
            @Override
            protected int getDimension() {
                return SquaredBoundedCoordinateTest.DIMENSION;
            }

            @Override
            protected String getErrorMessage() {
                return SquaredBoundedCoordinateTest.ERROR;
            }
        };
    }

    public int getDimension() {
        return SquaredBoundedCoordinateTest.DIMENSION;
    }

    public SquaredBoundedCoordinate getCoordinate(int row, int column) {
        return new SquaredBoundedCoordinate(row, column) {
            @Override
            protected int getDimension() {
                return SquaredBoundedCoordinateTest.DIMENSION;
            }

            @Override
            protected String getErrorMessage() {
                return SquaredBoundedCoordinateTest.ERROR;
            }
        };
    }

    @Test
    public void testGivenSquaredBoundedCoordinateWhenNewThenNull() {
        assertThat(this.getNullCoordinate().isNull(), is(true));
    }

    @Test
    public void testGivenSquaredBoundedCoordinateWhenWithCorrectValuesThenValid() {
        int row = 0;
        int column = this.getDimension() - 1;
        SquaredBoundedCoordinate coordinate = this.getCoordinate(row, column);
        assertThat(coordinate.getRow(), is(row));
        assertThat(coordinate.getColumn(), is(column));
    }

    @Test
    public void testGivenSquaredBoundedCoordinateWhenGetLimitsThenCorrect() {
        int row = 0;
        int column = this.getDimension() - 1;
        SquaredBoundedCoordinate coordinate = this.getCoordinate(row + 1, column - 1);
        assertThat(coordinate.getLimits(), is(new ClosedInterval(row, column)));
    }

    @Test
    public void testGivenSquaredBoundedCoordinateWhenGetDirectionThenNullDirection() {
        int position = this.getDimension() / 2;
        SquaredBoundedCoordinate coordinate = this.getCoordinate(position, position);
        assertThat(coordinate.getDirection(this.getCoordinate(position, 2)), is(Direction.HORIZONTAL));
        assertThat(coordinate.getDirection(this.getCoordinate(2, position)), is(Direction.VERTICAL));
        assertThat(coordinate.getDirection(this.getCoordinate(0, 0)), is(Direction.MAIN_DIAGONAL));
        assertThat(coordinate.getDirection(this.getCoordinate(0, this.getDimension() - 1)), is(Direction.INVERSE_DIAGONAL));
        assertThat(coordinate.getDirection(coordinate), is(Direction.NULL));
        assertThat(coordinate.getDirection(this.getNullCoordinate()), is(Direction.NULL));
    }

    @Test
    public void testGivenSquareBoundedCoordinateWhenReadThenCorrect() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            when(console.readInt(anyString())).thenReturn(this.getDimension());
            SquaredBoundedCoordinate coordinate = this.getNullCoordinate();
            coordinate.read("");
            assertThat(coordinate.getRow(), is(this.getDimension() - 1));
            assertThat(coordinate.getColumn(), is(this.getDimension() - 1));
        }
    }

    @Test
    public void testGivenSquareBoundedCoordinateWhenReadThenIncorrect() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            when(console.readInt(anyString())).thenReturn(this.getDimension() + 1, this.getDimension());
            SquaredBoundedCoordinate coordinate = this.getNullCoordinate();
            coordinate.read("");
            verify(console).writeln(coordinate.getErrorMessage());
        }
    }

}
