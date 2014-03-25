package com.pkw.find.violet;

public class GridShifter {

	private Position currentPosition = new Position(0, 0);
	private Position outputPosition = new Position(0, 0);
	private Grid outputGrid = new Grid();

	public Grid shiftRight(Grid grid) {
		resetOutputGrid();
		currentPosition = new Position(Grid.RIGHT_X, Grid.TOP_Y);
		outputPosition = currentPosition.clone();
		while (isNotAtBottom()) {
			while (isNotAtLeft()) {
				if (grid.hasBlockAt(currentPosition)) {
					Block block = grid.getBlockAt(currentPosition);
					copyBlockToOutputGrid(block);
					outputPosition.moveLeft();
				}
				currentPosition.moveLeft();
			}
			currentPosition.setX(Grid.RIGHT_X);
			currentPosition.moveDown();
			outputPosition = currentPosition.clone();
		}		return outputGrid;
	}

	private void resetOutputGrid() {
		outputGrid = new Grid();
	}

	private boolean isNotAtBottom() {
		return currentPosition.getY() <= Grid.BOTTOM_Y;
	}

	private boolean isNotAtLeft() {
		return currentPosition.getX() >= Grid.LEFT_X;
	}

	private void copyBlockToOutputGrid(Block block) {
		outputGrid.addBlockAt(block, outputPosition);
	}

	public Grid shiftLeft(Grid grid) {
		outputGrid = new Grid();
		currentPosition = new Position(Grid.LEFT_X, Grid.TOP_Y);
		outputPosition = currentPosition.clone();
		while (isNotAtBottom()) {
			while (isNotAtRight()) {
				if (grid.hasBlockAt(currentPosition)) {
					Block block = grid.getBlockAt(currentPosition);
					copyBlockToOutputGrid(block);
					outputPosition.moveRight();
				}
				currentPosition.moveRight();
			}
			currentPosition.setX(Grid.LEFT_X);
			currentPosition.moveDown();
			outputPosition = currentPosition.clone();
		}
		return outputGrid;
	}

	private boolean isNotAtRight() {
		return currentPosition.getX() <= Grid.RIGHT_X;
	}

	public Grid shiftDown(Grid grid) {
		outputGrid = new Grid();
		currentPosition = new Position(Grid.RIGHT_X, Grid.BOTTOM_Y);
		outputPosition = currentPosition.clone();
		while (isNotAtLeft()) {
			while (isNotAtTop()) {
				if (grid.hasBlockAt(currentPosition)) {
					Block block = grid.getBlockAt(currentPosition);
					copyBlockToOutputGrid(block);
					outputPosition.moveUp();
				}
				currentPosition.moveUp();
			}
			currentPosition.setY(Grid.BOTTOM_Y);
			currentPosition.moveLeft();
			outputPosition = currentPosition.clone();
		}
		return outputGrid;
	}

	private boolean isNotAtTop() {
		return currentPosition.getY() >= Grid.TOP_Y;
	}
}
