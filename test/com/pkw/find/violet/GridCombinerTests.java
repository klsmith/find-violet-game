package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GridCombinerTests {

	@Test
	public void testTwoTwoBlockCombineToRightOneFourBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.RIGHT_INDEX, Grid.TOP_INDEX));
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.RIGHT_INDEX - 1, Grid.TOP_INDEX));
		GridCombiner.combineToRight(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.FOUR,
				Position.createAt(Grid.RIGHT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoTwoBlockCombineToRightOneFourBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoRightColumns(actual);
		GridCombiner.combineToRight(actual);
		Grid expected = Grid.create();
		fillGridToBottomStartingAt(expected,
				Position.createAt(Grid.RIGHT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	// private void printGrids(Grid actual, Grid expected) {
	// System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
	// + "\n");
	// }

	private void fillTwoRightColumns(Grid grid) {
		Position currentPosition = Position.createAt(Grid.RIGHT_INDEX,
				Grid.TOP_INDEX);
		while (currentPosition.getY() <= Grid.BOTTOM_INDEX) {
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.moveLeft();
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.setX(Grid.RIGHT_INDEX);
			currentPosition.moveDown();
		}
	}

	private void fillGridToBottomStartingAt(Grid grid, Position currentPosition) {
		while (currentPosition.getY() <= Grid.BOTTOM_INDEX) {
			grid.addBlockAt(Block.FOUR, currentPosition);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testTwoTwoBlockCombineToLeftOneFourBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX + 1, Grid.TOP_INDEX));
		GridCombiner.combineToLeft(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.FOUR,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoTwoBlockCombineToLeftOneFourBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoLeftColumns(actual);
		GridCombiner.combineToLeft(actual);
		Grid expected = Grid.create();
		fillGridToBottomStartingAt(expected,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	private void fillTwoLeftColumns(Grid grid) {
		Position currentPosition = Position.createAt(Grid.LEFT_INDEX,
				Grid.TOP_INDEX);
		while (currentPosition.getY() <= Grid.BOTTOM_INDEX) {
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.moveRight();
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.setX(Grid.LEFT_INDEX);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testTwoTwoBlockCombineToTopOneFourBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX + 1));
		GridCombiner.combineToTop(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.FOUR,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testTwoTwoBlockCombineToTopOneFourBlockMultipleLines() {
		Grid actual = Grid.create();
		fillTwoTopRows(actual);
		GridCombiner.combineToTop(actual);
		Grid expected = Grid.create();
		fillGridToRightStartingAt(expected,
				Position.createAt(Grid.LEFT_INDEX, Grid.TOP_INDEX));
		assertTrue(actual.equals(expected));
	}

	private void fillTwoTopRows(Grid grid) {
		Position currentPosition = Position.createAt(Grid.LEFT_INDEX,
				Grid.TOP_INDEX);
		while (currentPosition.getX() <= Grid.RIGHT_INDEX) {
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.moveDown();
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.setY(Grid.TOP_INDEX);
			currentPosition.moveRight();
		}
	}

	private void fillGridToRightStartingAt(Grid grid, Position position) {
		while (position.getX() <= Grid.RIGHT_INDEX) {
			grid.addBlockAt(Block.FOUR, position);
			position.moveRight();
		}
	}

	@Test
	public void testTwoTwoBlockCombineToBottomOneFourBlock() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX, Grid.BOTTOM_INDEX));
		actual.addBlockAt(Block.TWO,
				Position.createAt(Grid.LEFT_INDEX, Grid.BOTTOM_INDEX - 1));
		GridCombiner.combineToBottom(actual);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.FOUR,
				Position.createAt(Grid.LEFT_INDEX, Grid.BOTTOM_INDEX));
		assertTrue(actual.equals(expected));
	}
}
