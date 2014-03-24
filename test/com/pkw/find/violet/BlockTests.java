package com.pkw.find.violet;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTests {

	@Test
	public void testREDgetNextIsREDORANGE() {
		Block actual = Block.RED.getNext();
		Block expected = Block.RED_ORANGE;
		assertEquals(expected, actual);
	}

	@Test
	public void testVIOLETgetNextIsNONE() {
		Block actual = Block.VIOLET.getNext();
		Block expected = Block.NONE;
		assertEquals(expected, actual);
	}
}
