package com.pkw.find.violet;

import static com.pkw.find.violet.Color.RED;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridTests {

	private Grid grid;
	private final Block redBlock = new Block(RED);
	private final Position topLeft = new Position(0, 0);
	private final Position topRight = new Position(3, 0);

	@Before
	public void setup() {
		grid = new Grid();
	}

	@Test
	public void testAddREDBlockAtTopLeftPoint() {
		grid.addBlockAt(redBlock, topLeft);
		Block actual = grid.getBlockAt(topLeft);
		Block expected = redBlock;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testAddREDBlockAtTopRightPoint() {
		grid.addBlockAt(redBlock, topRight);
		Block actual = grid.getBlockAt(topRight);
		Block expected = redBlock;
		assertTrue(actual.equals(expected));
	}
}
