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
		grid = new Grid();
	}

	@Test
	public void testAddREDBlockAtTopLeftPoint() {
		grid.addBlockAt(NewBlock.RED, topLeft);
		NewBlock actual = grid.getBlockAt(topLeft);
		NewBlock expected = NewBlock.RED;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testAddREDBlockAtTopRightPoint() {
		grid.addBlockAt(NewBlock.RED, topRight);
		NewBlock actual = grid.getBlockAt(topRight);
		NewBlock expected = NewBlock.RED;
		assertTrue(actual.equals(expected));
	}
}
