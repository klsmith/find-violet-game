package com.pkw.find.violet;

import java.awt.Color;
//Hello World
public enum Block {
	EMPTY(0, "    ", new Color(0, 0, 0)), //
	TWO(2, "  2 ", new Color(255, 0, 0)), //
	FOUR(4, "  4 ", new Color(255, 136, 0)), //
	EIGHT(8, "  8 ", new Color(238, 255, 0)), //
	SIXTEEN(16, " 16 ", new Color(136, 255, 0)), //
	THIRTY_TWO(32, " 32 ", new Color(0, 140, 0)), //
	SIXTY_FOUR(64, " 64 ", new Color(0, 255, 136)), //
	ONE_TWENTY_EIGHT(128, " 128", new Color(0, 204, 255)), //
	TWO_FIFTY_SIX(256, " 256", new Color(0, 111, 166)), //
	FIVE_TWELVE(512, " 512", new Color(0, 0, 128)), //
	TEN_TWENTY_FOUR(1024, "1024", new Color(161, 115, 230)), //
	TWENTY_FORTY_EIGHT(2048, "2048", new Color(204, 0, 255));

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
