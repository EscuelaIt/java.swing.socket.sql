package usantatecla.mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.console.ColorView;
import usantatecla.utils.WithConsoleView;
import usantatecla.mastermind.views.MessageView;

class ProposedCombinationView extends WithConsoleView {
	
	private Logic logic;
	
	ProposedCombinationView(Logic logic) {
		this.logic = logic;
	}
	
	void write(int i) {
		for (Color color : this.logic.getColors(i)) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
