package com.pkw.find.violet;

public enum NewBlock {
					// original game values:
	RED,			// 2
	RED_ORANGE,		// 4
	ORANGE,			// 8
	YELLOW_ORANGE,	// 16
	YELLOW,			// 32
	YELLOW_GREEN,	// 64
	GREEN,			// 128
	BLUE_GREEN,		// 256
	BLUE,			// 512
	BLUE_VIOLET,	// 1024
	VIOLET;			// 2048

	public NewBlock getNext() {
		return values()[(ordinal() + 1) % values().length];
	}
}
