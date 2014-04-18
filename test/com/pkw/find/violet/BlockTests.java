package com.pkw.find.violet;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTests {

	@Test
	public void testREDgetNextIsREDORANGE() {
		Block actual = Block.TWO.getNext();
		Block expected = Block.FOUR;
		assertEquals(expected, actual);
	}

	@Test
	public void testVIOLETgetNextIsNONE() {
		Block actual = Block.TWENTY_FORTY_EIGHT.getNext();
		Block expected = Block.EMPTY;
		assertEquals(expected, actual);
	}
}
