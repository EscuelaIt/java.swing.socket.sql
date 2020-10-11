package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Color;

public class ColorView {
	
	public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	protected Color color;

	protected ColorView(Color color) {
		this.color = color;
	}

	static String allInitials() {
		String result = "";
		for(char character: ColorView.INITIALS) {
			result += character;
		}
		return result;
	}

	public static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}

}
