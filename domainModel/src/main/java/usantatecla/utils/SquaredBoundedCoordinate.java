package usantatecla.utils;

import java.util.Random;

public abstract class SquaredBoundedCoordinate {

	private Coordinate adaptee;

	public SquaredBoundedCoordinate() {
		this.adaptee = NullCoordinate.getInstance();
	}

	public boolean isNull() {
		return this.adaptee.isNull();
	}

	public SquaredBoundedCoordinate(int row, int column) {
		this.adaptee = new ConcreteCoordinate(row, column);

		assert this.isValid();
	}

	private boolean isValid() {
		assert !this.adaptee.isNull();

		ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
		return this.getLimits().isIncluded(concreteCoordinate.getRow()) 
			&& this.getLimits().isIncluded(concreteCoordinate.getColumn());
	}

	protected ClosedInterval getLimits(){
		return new ClosedInterval(0, this.getDimension() - 1);
	};

	public Direction getDirection(SquaredBoundedCoordinate coordinate) {
		if (this.equals(coordinate) || this.isNull() || coordinate.isNull()){
			return Direction.NULL;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return this.adaptee.getDirection(coordinate.adaptee);
	}

	private boolean inInverseDiagonal() {
		ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
		return coordinate.getRow() + coordinate.getColumn() == this.getDimension() - 1;
	}

	protected abstract int getDimension();

	public void read(String message) {
		assert message != null;

		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		boolean error;
		do {
			coordinate.read(message);
			error = !this.isValid();
			if (error) {
				Console.getInstance().writeln(this.getErrorMessage());
			}
		} while (error);
		this.adaptee = coordinate;
	}

	protected abstract String getErrorMessage();

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.adaptee = new ConcreteCoordinate(random.nextInt(this.getDimension()), random.nextInt(this.getDimension()));
	}

	public int getRow() {
		assert !this.adaptee.isNull();

		return ((ConcreteCoordinate) this.adaptee).getRow();
	}

	public int getColumn() {
		assert !this.adaptee.isNull();

		return ((ConcreteCoordinate) this.adaptee).getColumn();
	}

}
