package com.pkw.find.violet;

public abstract class GridShifter {

	private static Grid thisGrid;
	private static Position currentPosition;
	private static Position newPosition;

	public static void shiftToRight(Grid grid) {
		thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (currentPositionIsNotAtBottom()) {
			newPosition = currentPosition.clone();
			while (currentPositionIsNotAtLeft()) {
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

	private static boolean currentPositionIsNotAtBottom() {
		return currentPosition.getY() <= Grid.BOTTOM_Y;
	}

	private static boolean currentPositionIsNotAtLeft() {
		return currentPosition.getX() >= Grid.LEFT_X;
	}

	private static void moveBlockToNewPosition() {
		Block block = thisGrid.getBlockAt(currentPosition);
		thisGrid.removeBlockAt(currentPosition);
		thisGrid.addBlockAt(block, newPosition);
	}

	public static void shiftToLeft(Grid grid) {
		thisGrid = grid;
		currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
		while (currentPositionIsNotAtBottom()) {
			newPosition = currentPosition.clone();
			while (currentPositionIsNotAtRight()) {
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

	private static boolean currentPositionIsNotAtRight() {
		return currentPosition.getX() <= Grid.RIGHT_X;
	}

	public static void shiftToBottom(Grid grid) {
		thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.BOTTOM_Y);
		while (currentPositionIsNotAtLeft()) {
			newPosition = currentPosition.clone();
			while (currentPoitionIsNotAtTop()) {
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

	private static boolean currentPoitionIsNotAtTop() {
		return currentPosition.getY() >= Grid.TOP_Y;
	}

	public static void shiftToTop(Grid grid) {
		thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (currentPositionIsNotAtLeft()) {
			newPosition = currentPosition.clone();
			while (currentPositionIsNotAtBottom()) {
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
