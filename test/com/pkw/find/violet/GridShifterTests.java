package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridShifterTests {

	private Grid grid;
	private final Position topLeft = Position.createAt(0, 0);
	private final Position topRight = Position.createAt(3, 0);
	private final Position bottomRight = Position.createAt(3, 3);
	private final Position bottomLeft = Position.createAt(0, 3);

	@Before
	public void setup() {
		resetGrid();
	}

	private void resetGrid() {
		grid = Grid.create();
	}

	// private void printGrids(Grid actual, Grid expected) {
	// System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
	// + "\n");
	// }

	@Test
	public void testOneREDBlockShiftRight() {
		grid.addBlockAt(Block.TWO, topLeft);
		GridShifter.shiftToRight(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.TWO, topRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftLeft() {
		grid.addBlockAt(Block.TWO, topRight);
		GridShifter.shiftToLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.TWO, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftRightThenLeft() {
		grid.addBlockAt(Block.TWO, topLeft);
		GridShifter.shiftToRight(grid);
		GridShifter.shiftToLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.TWO, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftRightMultipleLines() {
		fillGridToBottomStartingAt(topLeft);
		GridShifter.shiftToRight(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToBottomStartingAt(topRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	private void fillGridToBottomStartingAt(Position currentPosition) {
		while (currentPosition.getY() <= Grid.BOTTOM_INDEX) {
			grid.addBlockAt(Block.TWO, currentPosition);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testREDBlockShiftLeftMultipleLines() {
		fillGridToBottomStartingAt(topRight);
		GridShifter.shiftToLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToBottomStartingAt(topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testREDBlockShiftDown() {
		grid.addBlockAt(Block.TWO, topRight);
		GridShifter.shiftToBottom(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.TWO, bottomRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftDownMultipleLines() {
		fillGridToRightStartingAt(topLeft);
		GridShifter.shiftToBottom(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToRightStartingAt(bottomLeft);
		GridShifter.shiftToBottom(grid);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	private void fillGridToRightStartingAt(Position position) {
		while (position.getX() <= Grid.RIGHT_INDEX) {
			grid.addBlockAt(Block.TWO, position);
			position.moveRight();
		}
	}

	@Test
	public void testRedBlockShiftUp() {
		grid.addBlockAt(Block.TWO, bottomLeft);
		GridShifter.shiftToTop(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.TWO, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftUpMulipleLines() {
		fillGridToRightStartingAt(bottomLeft);
		GridShifter.shiftToTop(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToRightStartingAt(topLeft);
		GridShifter.shiftToTop(grid);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}
}
