package com.pkw.find.violet;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTests {

	@Test
	public void testClone() {
		Position actual = new Position(0, 0);
		Position expected = actual.clone();
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testToString() {
		String actual = new Position(0, 0).toString();
		String expected = "Position(0, 0)";
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testNotEquals() {
		Position actual = new Position(0, 0);
		Position notExpected = new Position(1, 0);
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testNotEqualsNull() {
		Position actual = new Position(0, 0);
		Position notExpected = null;
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testNotEqualToNonPosition() {
		Position actual = new Position(0, 0);
		Object notExpected = new Object();
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testEqualsSelf() {
		Position actual = new Position(0, 0);
		Position expected = actual;
		assertTrue(actual.equals(expected));
	}
}
