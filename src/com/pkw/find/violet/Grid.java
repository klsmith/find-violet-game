package com.pkw.find.violet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Grid {

	public static final int SIZE = 4;
	public static final int LEFT_INDEX = 0;
	public static final int TOP_INDEX = 0;
	public static final int RIGHT_INDEX = 3;
	public static final int BOTTOM_INDEX = 3;
	public static final int GRID_SIZE_IN_PIXELS = 128;
	public static final Block EMPTY = Block.NONE;

	private Block[] array = {//
	EMPTY, EMPTY, EMPTY, EMPTY,//
			EMPTY, EMPTY, EMPTY, EMPTY,//
			EMPTY, EMPTY, EMPTY, EMPTY,//
			EMPTY, EMPTY, EMPTY, EMPTY };

	private Grid() {

	}

	public static Grid create() {
		return new Grid();
	}

	public Grid addBlockAt(Block block, Position position) {
		array[getCoordinateValueOf(position)] = block;
		return this;
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
		return !getBlockAt(position).equals(EMPTY);
	}

	@Override
	public Grid clone() {
		Grid newGrid = new Grid();
		Position currentPosition = Position.createAt(0, 0);
		while (currentPosition.getY() <= BOTTOM_INDEX) {
			while (currentPosition.getX() <= RIGHT_INDEX) {
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

		Position tempPosition = Position.createAt(0, 0);
		while (tempPosition.getY() < SIZE) {
			result += "|     |     |     |     |\n";
			while (tempPosition.getX() < SIZE) {
				Block block = getBlockAt(tempPosition);
				String abbreviation = block.getAbbreviation();
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
			return hasSameBlockPositionsAs(otherGrid);
		} else {
			return false;
		}
	}

	public boolean hasSameBlockPositionsAs(Grid otherGrid) {
		Position currentPosition = Position.createAt(0, 0);
		while (currentPosition.getY() <= BOTTOM_INDEX) {
			while (currentPosition.getX() <= RIGHT_INDEX) {
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

	public void removeBlockAt(Position position) {
		addBlockAt(EMPTY, position);
	}

	public void right() {
		GridCombiner.combineToRight(this);
		GridShifter.shiftToRight(this);

	}

	public void left() {
		GridCombiner.combineToLeft(this);
		GridShifter.shiftToLeft(this);

	}

	public void up() {
		GridCombiner.combineToTop(this);
		GridShifter.shiftToTop(this);

	}

	public void down() {
		GridCombiner.combineToBottom(this);
		GridShifter.shiftToBottom(this);

	}

	public void draw(Graphics2D drawer) {
		Position currentPosition = Position.createAt(0, 0);
		while (isNotAtBottom(currentPosition)) {
			while (isNotAtRight(currentPosition)) {
				drawBlockAt(drawer, currentPosition);
				currentPosition.moveRight();
			}
			currentPosition.setX(0);
			currentPosition.moveDown();
		}
	}

	private boolean isNotAtBottom(Position position) {
		return position.getY() <= Grid.BOTTOM_INDEX;
	}

	private boolean isNotAtRight(Position position) {
		return position.getX() <= Grid.RIGHT_INDEX;
	}

	private void drawBlockAt(Graphics2D drawer, Position position) {
		Block block = getBlockAt(position);

		int x = position.getX() * GRID_SIZE_IN_PIXELS;
		int y = position.getY() * GRID_SIZE_IN_PIXELS;
		drawer.setColor(block.getAWTColor());
		drawer.fill(new Rectangle(x, y, GRID_SIZE_IN_PIXELS,
				GRID_SIZE_IN_PIXELS));
		drawer.setColor(Color.BLACK);
		int center = GRID_SIZE_IN_PIXELS / 2;
		drawer.drawString("" + block.getNumber(), x + center, y + center);
		drawer.draw(new Rectangle(x, y, GRID_SIZE_IN_PIXELS,
				GRID_SIZE_IN_PIXELS));
	}
}
