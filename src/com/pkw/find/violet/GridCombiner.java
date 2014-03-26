package com.pkw.find.violet;

public class GridCombiner {

	private static Grid thisGrid;
	private static Position currentPosition;
	private static Position scanPosition;

	public static void combineToRight(Grid grid) {
		thisGrid = grid;
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (isNotAtBottom(currentPosition)) {
			while (isNotAtLeft(currentPosition)) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					combineNextSimilarBlockFromRight();
				}
				currentPosition.moveLeft();
			}
			currentPosition.setX(Grid.RIGHT_X);
			currentPosition.moveDown();
		}
	}

	private static boolean isNotAtBottom(Position position) {
		return position.getY() <= Grid.BOTTOM_Y;
	}

	private static boolean isNotAtLeft(Position position) {
		return position.getX() >= Grid.LEFT_X;
	}

	private static void combineNextSimilarBlockFromRight() {
		scanPosition = currentPosition.clone();
		scanPosition.moveLeft();
		while (isNotAtLeft(scanPosition)) {
			if (thisGrid.hasBlockAt(scanPosition)) {
				if (foundBlockIsSimilar()) {
					combine();
				} else {
					return;
				}
			}
			scanPosition.moveLeft();
		}
	}

	private static boolean foundBlockIsSimilar() {
		Block originalBlock = thisGrid.getBlockAt(currentPosition);
		Block foundBlock = thisGrid.getBlockAt(scanPosition);
		return originalBlock.equals(foundBlock);
	}

	private static void combine() {
		Block originalBlock = thisGrid.getBlockAt(currentPosition);
		thisGrid.removeBlockAt(scanPosition);
		thisGrid.addBlockAt(originalBlock.getNext(), currentPosition);
	}

}
