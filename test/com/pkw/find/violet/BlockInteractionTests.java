package com.pkw.find.violet;

import static com.pkw.find.violet.Color.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BlockInteractionTests {

	private final Block redBlock = new Block(RED);
	private final Block redOrangeBlock = new Block(RED_ORANGE);
	private final Block orangeBlock = new Block(ORANGE);
	private final Block violetBlock = new Block(VIOLET);

	@Test
	public void testAdvanceREDIsRED_ORANGE() {
		Block actual = redBlock.advance();
		Block expected = redOrangeBlock;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testAdvanceRED_ORANGEIsORANGE() {
		Block actual = redOrangeBlock.advance();
		Block expected = orangeBlock;
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testAdvanceVIOLETIsVIOLET() {
		Block actual = violetBlock.advance();
		Block expected = violetBlock;
		assertTrue(actual.equals(expected));
	}
}
