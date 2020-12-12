package usantatecla.mastermind.views;

enum Message {
	ATTEMPTS("#attempts attempt(s): "), 
	SECRET("*"), 
	RESUME("Do you want to continue"), 
	RESULT(" --> #blacks blacks and #whites whites"), 
	PROPOSED_COMBINATION("Propose a combination: "), 
	TITLE("----- MASTERMIND -----"), 
	WINNER("You've won!!! ;-)"), 
	LOOSER("You've lost!!! :-("), 
	PROPOSE_COMMAND("Propose Combination"), 
	UNDO_COMMAND("Undo previous Proposal"), 
	REDO_COMMAND("Redo previous Proposal");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
