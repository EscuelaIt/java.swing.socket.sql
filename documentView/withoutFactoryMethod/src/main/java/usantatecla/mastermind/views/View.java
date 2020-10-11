package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

public abstract class View {

	protected Game game;

	public View(Game game) {
		this.game = game;
	}

	public void interact() {
		boolean newGame;
		do {
			this.start();
			boolean finished;
			do {
				finished = this.propose();
			} while (!finished);
			newGame = this.isNewGame();
		} while (newGame);
	}

	protected abstract void start();

	protected abstract boolean propose();

	protected abstract boolean isNewGame();

}
