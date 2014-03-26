package com.pkw.find.violet;

public abstract class GridShifter {

	private static Position currentPosition;
	private static Position newPosition;
	private static Grid thisGrid;

	public static void shiftToRight(Grid grid) {
		GridShifter.thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (isNotAtBottom()) {
			newPosition = currentPosition.clone();
			while (isNotAtLeft()) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					moveBlockToNewPosition();
					newPosition.moveLeft();
				}
				currentPosition.moveLeft();
			}
			currentPosition.setX(Grid.RIGHT_X);
			currentPosition.moveDown();
		}
	}

	private static boolean isNotAtBottom() {
		return currentPosition.getY() <= Grid.BOTTOM_Y;
	}

	private static boolean isNotAtLeft() {
		return currentPosition.getX() >= Grid.LEFT_X;
	}

	private static void moveBlockToNewPosition() {
		Block block = thisGrid.getBlockAt(currentPosition);
		thisGrid.removeBlockAt(currentPosition);
		thisGrid.addBlockAt(block, newPosition);
	}

	public static void shiftToLeft(Grid grid) {
		GridShifter.thisGrid = grid;
		currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
		while (isNotAtBottom()) {
			newPosition = currentPosition.clone();
			while (isNotAtRight()) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					moveBlockToNewPosition();
					newPosition.moveRight();
				}
				currentPosition.moveRight();
			}
			currentPosition.setX(Grid.LEFT_X);
			currentPosition.moveDown();

		}
	}

	private static boolean isNotAtRight() {
		return currentPosition.getX() <= Grid.RIGHT_X;
	}

	public static void shiftToBottom(Grid grid) {
		GridShifter.thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.BOTTOM_Y);
		while (isNotAtLeft()) {
			newPosition = currentPosition.clone();
			while (isNotAtTop()) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					moveBlockToNewPosition();
					newPosition.moveUp();
				}
				currentPosition.moveUp();
			}
			currentPosition.setY(Grid.BOTTOM_Y);
			currentPosition.moveLeft();
		}
	}

	private static boolean isNotAtTop() {
		return currentPosition.getY() >= Grid.TOP_Y;
	}

	public static void shiftToTop(Grid grid) {
		GridShifter.thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (isNotAtLeft()) {
			newPosition = currentPosition.clone();
			while (isNotAtBottom()) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					moveBlockToNewPosition();
					newPosition.moveDown();
				}
				currentPosition.moveDown();
			}
			currentPosition.setY(Grid.TOP_Y);
			currentPosition.moveLeft();
		}
	}
}
