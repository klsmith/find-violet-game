package com.pkw.find.violet;

import java.awt.Color;

public enum Block {
	NONE(0, "   ", new Color(0, 0, 0)), //
	RED(2, "RED", new Color(255, 0, 0)), //
	RED_ORANGE(4, "ROR", new Color(255, 136, 0)), //
	ORANGE(8, "ORG", new Color(238, 255, 0)), //
	YELLOW_ORANGE(16, "YOR", new Color(136, 255, 0)), //
	YELLOW(32, "YLW", new Color(0, 140, 0)), //
	YELLOW_GREEN(64, "YGR", new Color(0, 255, 136)), //
	GREEN(128, "GRN", new Color(0, 204, 255)), //
	BLUE_GREEN(256, "BGR", new Color(0, 111, 166)), //
	BLUE(512, "BLU", new Color(0, 0, 128)), //
	BLUE_VIOLET(1024, "BVL", new Color(161, 115, 230)), //
	VIOLET(2048, "VLT", new Color(204, 0, 255));

	private String abbreviation;
	private int number;
	private Color color;

	private Block(int number, String abbreviation, Color color) {
		this.number = number;
		this.abbreviation = abbreviation;
		this.color = color;
	}

	public String getAbbreviation() {
		return abbreviation;

	}

	public int getNumber() {
		return number;
	}

	public Block getNext() {
		return values()[(ordinal() + 1) % values().length];
	}

	public Color getAWTColor() {
		return color;
	}
}
