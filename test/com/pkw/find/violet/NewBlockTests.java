package com.pkw.find.violet;

import org.junit.Test;
import static org.junit.Assert.*;

public class NewBlockTests {

	@Test
	public void testREDgetNextIsREDORANGE() {
		NewBlock actual = NewBlock.RED.getNext();
		NewBlock expected = NewBlock.RED_ORANGE;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVIOLETgetNextIsRED() {
		NewBlock actual = NewBlock.VIOLET.getNext();
		NewBlock expected = NewBlock.RED;
		assertEquals(expected, actual);
	}
}
