package com.pkw.find.violet;

import java.awt.Color;
import java.awt.Shape;

public enum Block {
	NONE(0, "   ", new Color(255, 255, 255)), //
	RED(2, "RED", new Color(255, 0, 0)), //
	RED_ORANGE(4, "ROR", new Color(255, 85, 0)), //
	ORANGE(8, "ORG", new Color(255, 170, 0)), //
	YELLOW_ORANGE(16, "YOR", new Color(170, 255, 0)), //
	YELLOW(32, "YLW", new Color(255, 255, 0)), //
	YELLOW_GREEN(64, "YGR", new Color(170, 170, 255)), //
	GREEN(128, "GRN", new Color(0, 255, 0)), //
	BLUE_GREEN(256, "BGR", new Color(0, 170, 255)), //
	BLUE(512, "BLU", new Color(0, 0, 255)), //
	BLUE_VIOLET(1024, "BVL", new Color(170, 0, 255)), //
	VIOLET(2048, "VLT", new Color(255, 0, 255));

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
