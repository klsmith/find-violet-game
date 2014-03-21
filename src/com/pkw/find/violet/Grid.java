package com.pkw.find.violet;

public class Grid {

	public static final int SIZE = 4;
	public static final int LEFT_X = 0;
	public static final int TOP_Y = 0;
	public static final int RIGHT_X = 3;
	public static final int BOTTOM_Y = 3;
	public static final Block empty = new Block(Color.NONE);

	private Block[] array = {//
	empty, empty, empty, empty,//
			empty, empty, empty, empty,//
			empty, empty, empty, empty,//
			empty, empty, empty, empty };

	public void addBlockAt(Block block, Position position) {
		array[getCoordinateValueOf(position)] = block;
	}

	public Block getBlockAt(Position position) {
		return array[getCoordinateValueOf(position)];
	}

	private int getCoordinateValueOf(Position position) {
		int x = position.getX();
		int y = position.getY();
		return x + (y * SIZE);
	}

	public boolean hasBlockAt(Position position) {
		return !getBlockAt(position).equals(empty);
	}

	@Override
	public Grid clone() {
		Grid newGrid = new Grid();
		Position currentPosition = new Position(0, 0);
		while (currentPosition.getY() <= BOTTOM_Y) {
			while (currentPosition.getX() <= RIGHT_X) {
				Block block = getBlockAt(currentPosition);
				newGrid.addBlockAt(block, currentPosition);
				currentPosition.moveRight();
			}
			currentPosition.setX(0);
			currentPosition.moveDown();
		}
		return newGrid;
	}

	@Override
	public String toString() {
		String result = " _______________________\n";

		Position tempPosition = new Position(0, 0);
		while (tempPosition.getY() < SIZE) {
			result += "|     |     |     |     |\n";
			while (tempPosition.getX() < SIZE) {
				Block block = getBlockAt(tempPosition);
				String abbreviation = block.getColor().getAbbreviation();
				result += "| " + abbreviation + " ";
				tempPosition.moveRight();
			}
			result += "|\n";
			result += "|_____|_____|_____|_____|\n";
			tempPosition.setX(0);
			tempPosition.moveDown();
		}
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (other instanceof Grid) {
			Grid otherGrid = (Grid) other;
			return compareValuesWith(otherGrid);
		} else {
			return false;
		}
	}

	public boolean compareValuesWith(Grid otherGrid) {
		Position currentPosition = new Position(0, 0);
		while (currentPosition.getY() <= BOTTOM_Y) {
			while (currentPosition.getX() <= RIGHT_X) {
				Block block = getBlockAt(currentPosition);
				Block otherBlock = otherGrid.getBlockAt(currentPosition);
				if (!block.equals(otherBlock)) {
					return false;
				}
				currentPosition.moveRight();
			}
			currentPosition.setX(0);
			currentPosition.moveDown();
		}
		return true;
	}
}
