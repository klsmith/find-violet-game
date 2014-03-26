package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GridCombinerTests {

	@Test
	public void testTwoRedBlockCombineToRightOneRedOrangeBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.RIGHT_X, Grid.TOP_Y));
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.RIGHT_X - 1, Grid.TOP_Y));
		GridCombiner.combineToRight(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE,
				Position.createAt(Grid.RIGHT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoRedBlockCombineToRightOneRedOrangeBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoRightColumns(actual);
		GridCombiner.combineToRight(actual);
		Grid expected = Grid.create();
		fillGridToBottomStartingAt(expected,
				Position.createAt(Grid.RIGHT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	private void printGrids(Grid actual, Grid expected) {
		System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
				+ "\n");
	}

	private void fillTwoRightColumns(Grid grid) {
		Position currentPosition = Position.createAt(Grid.RIGHT_X, Grid.TOP_Y);
		while (currentPosition.getY() <= Grid.BOTTOM_Y) {
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.moveLeft();
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.setX(Grid.RIGHT_X);
			currentPosition.moveDown();
		}
	}

	private void fillGridToBottomStartingAt(Grid grid, Position currentPosition) {
		while (currentPosition.getY() <= Grid.BOTTOM_Y) {
			grid.addBlockAt(Block.RED_ORANGE, currentPosition);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testTwoRedBlockCombineToLeftOneRedOrangeBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.RED, Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.LEFT_X + 1, Grid.TOP_Y));
		GridCombiner.combineToLeft(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE,
				Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoRedBlockCombineToLeftOneRedOrangeBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoLeftColumns(actual);
		GridCombiner.combineToLeft(actual);
		Grid expected = Grid.create();
		fillGridToBottomStartingAt(expected,
				Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	private void fillTwoLeftColumns(Grid grid) {
		Position currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
		while (currentPosition.getY() <= Grid.BOTTOM_Y) {
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.moveRight();
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.setX(Grid.LEFT_X);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testTwoRedBlockCombineToTopOneRedOrangeBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.RED, Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.LEFT_X, Grid.TOP_Y + 1));
		GridCombiner.combineToTop(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE,
				Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoRedBlockCombineToTopOneRedOrangeBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoTopRows(actual);
		GridCombiner.combineToTop(actual);
		Grid expected = Grid.create();
		fillGridToRightStartingAt(expected,
				Position.createAt(Grid.LEFT_X, Grid.TOP_Y));
		assertTrue(actual.equals(expected));
	}

	private void fillTwoTopRows(Grid grid) {
		Position currentPosition = Position.createAt(Grid.LEFT_X, Grid.TOP_Y);
		while (currentPosition.getX() <= Grid.RIGHT_X) {
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.moveDown();
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.setY(Grid.TOP_Y);
			currentPosition.moveRight();
		}
	}

	private void fillGridToRightStartingAt(Grid grid, Position position) {
		while (position.getX() <= Grid.RIGHT_X) {
			grid.addBlockAt(Block.RED_ORANGE, position);
			position.moveRight();
		}
	}

	@Test
	public void testTwoRedBlockCombineToBottomOneRedOrangeBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.LEFT_X, Grid.BOTTOM_Y));
		actual.addBlockAt(Block.RED,
				Position.createAt(Grid.LEFT_X, Grid.BOTTOM_Y - 1));
		GridCombiner.combineToBottom(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE,
				Position.createAt(Grid.LEFT_X, Grid.BOTTOM_Y));
		printGrids(actual, expected);
		assertTrue(actual.equals(expected));
	}
}
