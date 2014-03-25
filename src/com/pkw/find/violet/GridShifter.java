package com.pkw.find.violet;

public abstract class GridShifter {

	private static Position currentPosition = Position.createAt(0, 0);
	private static Position outputPosition = Position.createAt(0, 0);
	private static Grid outputGrid = Grid.create();

	public static Grid shiftRight(Grid grid) {
		resetOutputGrid();
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
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
		}
		return outputGrid;
	}

	private static void resetOutputGrid() {
		outputGrid = Grid.create();
	}

	private static boolean isNotAtBottom() {
		return currentPosition.getY() <= Grid.BOTTOM_Y;
	}

	private static boolean isNotAtLeft() {
		return currentPosition.getX() >= Grid.LEFT_X;
	}

	private static void copyBlockToOutputGrid(Block block) {
		outputGrid.addBlockAt(block, outputPosition);
	}

	public static Grid shiftLeft(Grid grid) {
		outputGrid = Grid.create();
		currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
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

	private static boolean isNotAtRight() {
		return currentPosition.getX() <= Grid.RIGHT_X;
	}

	public static Grid shiftDown(Grid grid) {
		outputGrid = Grid.create();
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.BOTTOM_Y);
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

	private static boolean isNotAtTop() {
		return currentPosition.getY() >= Grid.TOP_Y;
	}

	public static Grid shiftUp(Grid grid) {
		outputGrid = Grid.create();
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		outputPosition = currentPosition.clone();
		while (isNotAtLeft()) {
			while (isNotAtBottom()) {
				if (grid.hasBlockAt(currentPosition)) {
					Block block = grid.getBlockAt(currentPosition);
					copyBlockToOutputGrid(block);
					outputPosition.moveDown();
				}
				currentPosition.moveDown();
			}
			currentPosition.setY(Grid.TOP_Y);
			currentPosition.moveLeft();
			outputPosition = currentPosition.clone();
		}
		return outputGrid;
	}
}
