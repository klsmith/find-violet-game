package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridShifterTests {

	private Grid grid;
	private GridShifter shifter;
	private final Position topLeft = new Position(0, 0);
	private final Position topRight = new Position(3, 0);

	@Before
	public void setup() {
		shifter = new GridShifter();
		resetGrid();
	}

	private void resetGrid() {
		grid = new Grid();
	}

	// private void printGrids(String actual, String expected) {
	// System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
	// + "\n");
	// }

	@Test
	public void testOneREDBlockShiftRight() {
		grid.addBlockAt(Block.RED, topLeft);
		grid = shifter.shiftRight(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(Block.RED, topRight);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftLeft() {
		grid.addBlockAt(Block.RED, topRight);
		grid = shifter.shiftLeft(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(Block.RED, topLeft);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftRightThenLeft() {
		grid.addBlockAt(Block.RED, topLeft);
		grid = shifter.shiftRight(grid);
		grid = shifter.shiftLeft(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(Block.RED, topLeft);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRedBlockShiftRightMultipleLines() {
		fillGridToBottomStartingAt(topLeft);
		grid = shifter.shiftRight(grid);
		String actual = grid.toString();
		resetGrid();
		fillGridToBottomStartingAt(topRight);
		String expected = grid.toString();
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
		grid = shifter.shiftLeft(grid);
		String actual = grid.toString();
		resetGrid();
		fillGridToBottomStartingAt(topLeft);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}
}
