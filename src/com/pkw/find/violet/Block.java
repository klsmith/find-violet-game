package com.pkw.find.violet;

public class Block {

	private Color color;

	public Block(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public Block advance() {
		int value = color.getValue();
		Color newColor;
		if (value == Color.VIOLET.getValue() || value == Color.NONE.getValue()) {
			return this;
		} else {
			newColor = Color.colorFromValue(value + 1);
		}
		return new Block(newColor);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		} else if (other == null) {
			return false;
		} else if (other instanceof Block) {
			Block otherBlock = (Block) other;
			return color == otherBlock.color;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int PRIME = 7;
		return color.getValue() * PRIME;
	}

	@Override
	public String toString() {
		return "Block(" + color + ")";
	}
}
