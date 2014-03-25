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

	// private void printGrids(String actual, String expected) {
	// System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
	// + "\n");
	// }

	@Test
	public void testOneREDBlockShiftRight() {
		grid.addBlockAt(Block.RED, topLeft);
		grid = GridShifter.shiftRight(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.RED, topRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftLeft() {
		grid.addBlockAt(Block.RED, topRight);
		grid = GridShifter.shiftLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.RED, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftRightThenLeft() {
		grid.addBlockAt(Block.RED, topLeft);
		grid = GridShifter.shiftRight(grid);
		grid = GridShifter.shiftLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.RED, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftRightMultipleLines() {
		fillGridToBottomStartingAt(topLeft);
		grid = GridShifter.shiftRight(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToBottomStartingAt(topRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	private void fillGridToBottomStartingAt(Position currentPosition) {
		while (currentPosition.getY() <= Grid.BOTTOM_Y) {
			grid.addBlockAt(Block.RED, currentPosition);
			currentPosition.moveDown();
		}
	}

	@Test
	public void testREDBlockShiftLeftMultipleLines() {
		fillGridToBottomStartingAt(topRight);
		grid = GridShifter.shiftLeft(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToBottomStartingAt(topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testREDBlockShiftDown() {
		grid.addBlockAt(Block.RED, topRight);
		grid = GridShifter.shiftDown(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.RED, bottomRight);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftDownMultipleLines() {
		fillGridToRightStartingAt(topLeft);
		grid = GridShifter.shiftDown(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToRightStartingAt(bottomLeft);
		grid = GridShifter.shiftDown(grid);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	private void fillGridToRightStartingAt(Position position) {
		while (position.getX() <= Grid.RIGHT_X) {
			grid.addBlockAt(Block.RED, position);
			position.moveRight();
		}
	}

	@Test
	public void testRedBlockShiftUp() {
		grid.addBlockAt(Block.RED, bottomLeft);
		grid = GridShifter.shiftUp(grid);
		Grid actual = grid.clone();
		resetGrid();
		grid.addBlockAt(Block.RED, topLeft);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftUpMulipleLines() {
		fillGridToRightStartingAt(bottomLeft);
		grid = GridShifter.shiftUp(grid);
		Grid actual = grid.clone();
		resetGrid();
		fillGridToRightStartingAt(topLeft);
		grid = GridShifter.shiftUp(grid);
		Grid expected = grid.clone();
		assertTrue(actual.equals(expected));
	}
}
