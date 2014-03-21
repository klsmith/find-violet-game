package com.pkw.find.violet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridEqualityTests {

	private Block redBlock = new Block(Color.RED);
	private Position topLeft = new Position(0, 0);

	@Test
	public void testGridDoesNotEqualNull() {
		Grid actual = new Grid();
		Grid notExpected = null;
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testGridEqualsSelf() {
		Grid actual = new Grid();
		Grid expected = actual;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testGridsHaveBlocksAtSameLocation() {
		Grid actual = new Grid();
		actual.addBlockAt(redBlock, topLeft);
		Grid expected = new Grid();
		expected.addBlockAt(redBlock, topLeft);
		assertTrue(actual.equals(expected));
	}
}
