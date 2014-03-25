package com.pkw.find.violet;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridTests {

	private Grid grid;
	private final Position topLeft = new Position(0, 0);
	private final Position topRight = new Position(3, 0);

	@Before
	public void setup() {
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
}
