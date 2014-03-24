package com.pkw.find.violet;

public enum Block {
	NONE("   "), //
	RED("RED"), //
	RED_ORANGE("ROR"), //
	ORANGE("ORG"), //
	YELLOW_ORANGE("YOR"), //
	YELLOW("YLW"), //
	YELLOW_GREEN("YGR"), //
	GREEN("GRN"), //
	BLUE_GREEN("BGR"), //
	BLUE("BLU"), //
	BLUE_VIOLET("BVL"), //
	VIOLET("VLT");

	private String abbreviation;

	private Block(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public Block getNext() {
		return values()[(ordinal() + 1) % values().length];
	}
}
