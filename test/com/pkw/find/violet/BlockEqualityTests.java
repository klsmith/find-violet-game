package com.pkw.find.violet;

import static com.pkw.find.violet.Color.RED;
import static com.pkw.find.violet.Color.RED_ORANGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BlockEqualityTests {

	@Test
	public void testValuedBuildersAreEqual() {
		Block actual = new Block(RED);
		Block expected = new Block(RED);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testREDBuilderColorIsNotRED_ORANGE() {
		Color actual = new Block(RED).getColor();
		Color notExpected = RED_ORANGE;
		assertNotEquals(notExpected, actual);
	}

	@Test
	public void testREDBuilderAndRED_ORANGEConstructorNotEqual() {
		Block actual = new Block(RED);
		Block notExpected = new Block(RED_ORANGE);
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testDoesNotEqualNonBlock() {
		Block actual = new Block(RED);
		Object notExpected = new Object();
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testDoesNotEqualsNull() {
		Block actual = new Block(RED);
		Object notExpected = null;
		assertFalse(actual.equals(notExpected));
	}

	@Test
	public void testEqualsSelf() {
		Block actual = new Block(RED);
		Block expected = actual;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testRED_ORANGEBuilderColorIsRED_ORANGE() {
		Color actual = new Block(RED_ORANGE).getColor();
		Color expected = RED_ORANGE;
		assertEquals(expected, actual);
	}

	@Test
	public void testREDBuilderHasHashcodeOfFourteen() {
		int actual = new Block(RED).hashCode();
		int expected = 7;
		assertEquals(expected, actual);
	}

	@Test
	public void testREDToString() {
		String actual = new Block(RED).toString();
		String expected = "Block(RED)";
		assertTrue(actual.equals(expected));
	}
}
