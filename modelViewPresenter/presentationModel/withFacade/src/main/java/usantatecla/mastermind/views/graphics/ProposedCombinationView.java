package usantatecla.mastermind.views.graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ColorView;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {
	
	private Logic logic;

	ProposedCombinationView(Logic logic) {
		this.logic = logic;
		String initials = "";
		for (Color color : this.logic.getColors(this.logic.getAttempts()-1)) {
			initials += new ColorView(color).getInitial();
		}
		this.setText(initials);
	}

	ProposedCombinationView() {
	}

	List<Color> read(String characters) {
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}

}
