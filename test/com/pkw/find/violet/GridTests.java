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
		actual.down();
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 1))//
				.addBlockAt(Block.GREEN, Position.createAt(1, 1))//
				.addBlockAt(Block.YELLOW, Position.createAt(0, 2))//
				.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 2))//
				.addBlockAt(Block.YELLOW, Position.createAt(2, 2))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 3))//
				.addBlockAt(Block.ORANGE, Position.createAt(1, 3))//
				.addBlockAt(Block.RED, Position.createAt(2, 3))//
				.addBlockAt(Block.ORANGE, Position.createAt(3, 3));
		assertTrue(actual.equals(expected));
	}

	private Grid createSampleGrid() {
		grid.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 0))//
				.addBlockAt(Block.GREEN, Position.createAt(1, 0))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 0))//
				.addBlockAt(Block.YELLOW, Position.createAt(0, 1))//
				.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 1))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 1))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 1))//
				.addBlockAt(Block.RED, Position.createAt(0, 2))//
				.addBlockAt(Block.ORANGE, Position.createAt(1, 2))//
				.addBlockAt(Block.RED, Position.createAt(2, 2))//
				.addBlockAt(Block.RED, Position.createAt(0, 3))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 3));
		Grid clone = grid.clone();
		resetGrid();
		return clone;
	}

	@Test
	public void testUp() {
		Grid actual = createSampleGrid();
		actual.up();
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 0))//
				.addBlockAt(Block.GREEN, Position.createAt(1, 0))//
				.addBlockAt(Block.YELLOW, Position.createAt(2, 0))//
				.addBlockAt(Block.ORANGE, Position.createAt(3, 0))//
				.addBlockAt(Block.YELLOW, Position.createAt(0, 1))//
				.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 1))//
				.addBlockAt(Block.RED, Position.createAt(2, 1))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 2))//
				.addBlockAt(Block.ORANGE, Position.createAt(1, 2));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRight() {
		Grid actual = createSampleGrid();
		actual.right();
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(1, 0))//
				.addBlockAt(Block.GREEN, Position.createAt(2, 0))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(3, 0))//
				.addBlockAt(Block.YELLOW, Position.createAt(0, 1))//
				.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 1))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 1))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 1))//
				.addBlockAt(Block.RED, Position.createAt(1, 2))//
				.addBlockAt(Block.ORANGE, Position.createAt(2, 2))//
				.addBlockAt(Block.RED, Position.createAt(3, 2))//
				.addBlockAt(Block.RED, Position.createAt(2, 3))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 3));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testLeft() {
		Grid actual = createSampleGrid();
		actual.left();
		Grid expected = Grid.create();
		expected.addBlockAt(Block.RED_ORANGE, Position.createAt(0, 0))//
				.addBlockAt(Block.GREEN, Position.createAt(1, 0))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 0))//
				.addBlockAt(Block.YELLOW, Position.createAt(0, 1))//
				.addBlockAt(Block.YELLOW_GREEN, Position.createAt(1, 1))//
				.addBlockAt(Block.YELLOW_ORANGE, Position.createAt(2, 1))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(3, 1))//
				.addBlockAt(Block.RED, Position.createAt(0, 2))//
				.addBlockAt(Block.ORANGE, Position.createAt(1, 2))//
				.addBlockAt(Block.RED, Position.createAt(2, 2))//
				.addBlockAt(Block.RED, Position.createAt(0, 3))//
				.addBlockAt(Block.RED_ORANGE, Position.createAt(1, 3));
		assertTrue(actual.equals(expected));
	}
}
