package usantatecla.mastermind;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {
	
	private Logic logic;
	
	private View view;
	
	protected Mastermind() {
		this.logic = new Logic(this.isStandalone());
		this.view = new View();
	}

	protected abstract Boolean isStandalone();

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null); 
		if (!this.isStandalone()) {
			this.logic.close();
		}
	}
	
}

