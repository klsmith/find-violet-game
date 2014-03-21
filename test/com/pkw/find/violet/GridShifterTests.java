package com.pkw.find.violet;

import static com.pkw.find.violet.Color.RED;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridShifterTests {

	private Grid grid;
	private GridShifter shifter;
	private final Block redBlock = new Block(RED);
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

//	private void printGrids(String actual, String expected) {
//		System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
//				+ "\n");
//	}

	@Test
	public void testOneREDBlockShiftRight() {
		grid.addBlockAt(redBlock, topLeft);
		grid = shifter.shiftRight(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(redBlock, topRight);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftLeft() {
		grid.addBlockAt(redBlock, topRight);
		grid = shifter.shiftLeft(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(redBlock, topLeft);
		String expected = grid.toString();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testOneREDBlockShiftRightThenLeft() {
		grid.addBlockAt(redBlock, topLeft);
		grid = shifter.shiftRight(grid);
		grid = shifter.shiftLeft(grid);
		String actual = grid.toString();
		resetGrid();
		grid.addBlockAt(redBlock, topLeft);
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
			grid.addBlockAt(redBlock, currentPosition);
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
