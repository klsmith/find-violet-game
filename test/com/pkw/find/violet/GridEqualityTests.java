package com.pkw.find.violet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridEqualityTests {
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
	public void testGridsHaveBlocks_OneRedBlock() {
		Grid actual = new Grid();
		actual.addBlockAt(new Block(Color.RED), new Position(0, 0));
		Grid expected = new Grid();
		expected.addBlockAt(new Block(Color.RED), new Position(0, 0));
		assertTrue(actual.equals(expected));
	}
}
