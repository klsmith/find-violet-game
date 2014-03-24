package com.pkw.find.violet;

public enum NewBlock {
	RED, RED_ORANGE, VIOLET;

	public NewBlock getNext() {
		return values()[(ordinal() + 1) % values().length];
	}
}
