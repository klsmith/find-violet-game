package com.pkw.find.violet;

public class GridShifter {

	Position inputPosition = new Position(Grid.LEFT_X, Grid.TOP_Y);
	Position outputPosition = new Position(Grid.LEFT_X, Grid.TOP_Y);

	public Grid shiftRight(Grid grid) {
		Grid inputGrid = grid.clone();
		Grid outputGrid = new Grid();
		inputPosition = new Position(Grid.RIGHT_X, Grid.TOP_Y);
		outputPosition = inputPosition.clone();
		while (inputPosition.getY() <= Grid.BOTTOM_Y) {
			while (inputPosition.getX() >= Grid.LEFT_X) {
				if (inputGrid.hasBlockAt(inputPosition)) {
					Block block = inputGrid.getBlockAt(inputPosition);
					outputGrid.addBlockAt(block, outputPosition);
					outputPosition.moveLeft();
				}
				inputPosition.moveLeft();
			}
			inputPosition.setX(Grid.RIGHT_X);
			inputPosition.moveDown();
			outputPosition = inputPosition.clone();
		}
		return outputGrid;
	}

	public Grid shiftLeft(Grid grid) {
		Grid inputGrid = grid.clone();
		Grid outputGrid = new Grid();
		inputPosition = new Position(Grid.LEFT_X, Grid.TOP_Y);
		outputPosition = inputPosition.clone();
		while (inputPosition.getY() <= Grid.BOTTOM_Y) {
			while (inputPosition.getX() <= Grid.RIGHT_X) {
				if (inputGrid.hasBlockAt(inputPosition)) {
					Block block = inputGrid.getBlockAt(inputPosition);
					outputGrid.addBlockAt(block, outputPosition);
					outputPosition.moveRight();
				}
				inputPosition.moveRight();
			}
			inputPosition.setX(Grid.LEFT_X);
			inputPosition.moveDown();
			outputPosition = inputPosition.clone();
		}
		return outputGrid;
	}
	
	
}
