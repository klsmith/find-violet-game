package com.pkw.find.violet;

import org.junit.Test;
import static org.junit.Assert.*;

public class NewBlockTests {

	@Test
	public void test() {
		NewBlock actual = NewBlock.RED.getNext();
		NewBlock expected = NewBlock.RED_ORANGE;
		assertEquals(expected, actual);
	}
}
