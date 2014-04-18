package com.pkw.find.violet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GridEqualityTests {

	private Position topLeft = Position.createAt(0, 0);

	@Test
	public void testGridDoesNotEqualNull() {
		Grid actual = Grid.create();
		Grid notExpected = null;
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testGridEqualsSelf() {
		Grid actual = Grid.create();
		Grid expected = actual;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testGridsHaveBlocksAtSameLocation() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO, topLeft);
		Grid expected = Grid.create();
		expected.addBlockAt(Block.TWO, topLeft);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testGridsHaveBlocksNotSameLocation() {
		Grid actual = Grid.create();
		actual.addBlockAt(Block.TWO, topLeft);
		Grid notExpected = Grid.create();
		notExpected.addBlockAt(Block.TWO, Position.createAt(3, 0));
		assertFalse(actual.equals(notExpected));
	}
}
