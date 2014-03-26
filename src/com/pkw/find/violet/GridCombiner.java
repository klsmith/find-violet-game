package com.pkw.find.violet;

public abstract class GridCombiner {

	private static Grid thisGrid;
	private static Position currentPosition;
	private static Position scanPosition;

	public static void combineToRight(Grid grid) {
		thisGrid = grid;
		startAtTopRight();
		while (isNotAtBottom(currentPosition)) {
			while (isNotAtLeft(currentPosition)) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					combineNextSimilarBlockFromLeft();
				}
				currentPosition.moveLeft();
			}
			resetToRight();
			currentPosition.moveDown();
		}
	}

	private static void startAtTopRight() {
		currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
	}

	private static boolean isNotAtBottom(Position position) {
		return position.getY() <= Grid.BOTTOM_Y;
	}

	private static boolean isNotAtLeft(Position position) {
		return position.getX() >= Grid.LEFT_X;
	}

	private static void resetToRight() {
		currentPosition.setX(Grid.RIGHT_X);
	}

	private static void combineNextSimilarBlockFromLeft() {
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

	public static void combineToLeft(Grid grid) {
		thisGrid = grid;
		startAtTopLeft();
		while (isNotAtBottom(currentPosition)) {
			while (isNotAtRight(currentPosition)) {
				if (thisGrid.hasBlockAt(currentPosition)) {
					combineNextSimilarBlockFromRight();
				}
				currentPosition.moveRight();
			}
			resetToRight();
			currentPosition.moveDown();
		}

	}

	private static void startAtTopLeft() {
		currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
	}

	private static boolean isNotAtRight(Position position) {
		return position.getX() <= Grid.RIGHT_X;
	}

	private static void combineNextSimilarBlockFromRight() {
		scanPosition = currentPosition.clone();
		scanPosition.moveRight();
		while (isNotAtRight(scanPosition)) {
			if (thisGrid.hasBlockAt(scanPosition)) {
				if (foundBlockIsSimilar()) {
					combine();
				} else {
					return;
				}
			}
			scanPosition.moveRight();
		}
	}
}
