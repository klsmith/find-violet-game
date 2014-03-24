package com.pkw.find.violet;

public enum NewBlock {
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

	private NewBlock(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public NewBlock getNext() {
		return values()[(ordinal() + 1) % values().length];
	}
}
