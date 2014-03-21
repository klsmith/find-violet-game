package com.pkw.find.violet;

public enum Color {

	NONE(0), //
	RED(1), //
	RED_ORANGE(2), //
	ORANGE(3), //
	YELLOW_ORANGE(4), //
	YELLOW(5), //
	YELLOW_GREEN(6), //
	GREEN(07), //
	BLUE_GREEN(8), //
	BLUE(9), //
	BLUE_VIOLET(10), //
	VIOLET(11);

	private int value;

	private Color(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getAbbreviation() {
		switch (value) {
		case 1:
			return "RED";
		case 2:
			return "ROR";
		case 3:
			return "ORG";
		case 4:
			return "YOR";
		case 5:
			return "YLW";
		case 6:
			return "YGR";
		case 7:
			return "GRN";
		case 8:
			return "BGR";
		case 9:
			return "BLU";
		case 10:
			return "BVL";
		case 11:
			return "VLT";
		default:
			return "   ";
		}
	}

	public static Color colorFromValue(int value) {
		switch (value) {
		case 1:
			return RED;
		case 2:
			return RED_ORANGE;
		case 3:
			return ORANGE;
		case 4:
			return YELLOW_ORANGE;
		case 5:
			return YELLOW;
		case 6:
			return YELLOW_GREEN;
		case 7:
			return GREEN;
		case 8:
			return BLUE_GREEN;
		case 9:
			return BLUE;
		case 10:
			return BLUE_VIOLET;
		case 11:
			return VIOLET;
		default:
			return NONE;
		}
	}
}
