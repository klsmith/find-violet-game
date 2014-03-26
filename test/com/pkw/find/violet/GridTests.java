package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridTests {

	private Grid grid;
	private final Position topLeft = Position.createAt(0, 0);
	private final Position topRight = Position.createAt(3, 0);

	@Before
	public void setup() {
		resetGrid();
	}

	private void resetGrid() {
		grid = Grid.create();
	}

	private void printGrids(Grid actual, Grid expected) {
		System.out.println("\nActual:\n" + actual + "\nExpected:\n" + expected
				+ "\n");
	}

	@Test
	public void testAddREDBlockAtTopLeftPoint() {
		grid.addBlockAt(Block.RED, topLeft);
		Block actual = grid.getBlockAt(topLeft);
		Block expected = Block.RED;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testAddREDBlockAtTopRightPoint() {
		grid.addBlockAt(Block.RED, topRight);
		Block actual = grid.getBlockAt(topRight);
		Block expected = Block.RED;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testDown() {
		Grid actual = createSampleGrid();
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 1));
		expected.addBlockAt(Block.GREEN, Position.createAt(1, 1));
		expected.addBlockAt(Block.YELLOW, Position.createAt(0, 2));
		expected.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 2));
		expected.addBlockAt(Block.YELLOW, Position.createAt(2, 2));
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 3));
		expected.addBlockAt(Block.ORANGE, Position.createAt(1, 3));
		expected.addBlockAt(Block.RED, Position.createAt(2, 3));
		expected.addBlockAt(Block.ORANGE, Position.createAt(3, 3));
		printGrids(actual, expected);
		actual.down();
		printGrids(actual, expected);
		assertTrue(actual.equals(expected));
	}

	private Grid createSampleGrid() {
		grid.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 0));
		grid.addBlockAt(Block.GREEN, Position.createAt(1, 0));
		grid.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 0));
		grid.addBlockAt(Block.YELLOW, Position.createAt(0, 1));
		grid.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 1));
		grid.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 1));
		grid.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 1));
		grid.addBlockAt(Block.RED, Position.createAt(0, 2));
		grid.addBlockAt(Block.ORANGE, Position.createAt(1, 2));
		grid.addBlockAt(Block.RED, Position.createAt(2, 2));
		grid.addBlockAt(Block.RED, Position.createAt(0, 3));
		grid.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 3));
		Grid clone = grid.clone();
		resetGrid();
		return clone;
	}
}
