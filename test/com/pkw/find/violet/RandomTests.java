package com.pkw.find.violet;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomTests {

	public static final int SEED = 123;
	private Random random;

	@Before
	public void setup() {
		random = new Random(SEED);
	}

	public void incrementRandom(int amount) {
		for (int i = 0; i < amount; i++) {
			random.nextInt();
		}
	}

	@Test
	public void testFirstIncrement_AnswerOutOfFour() {
		int actual = random.nextInt(4);
		int expected = 2;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSecondIncrement_AnswerOutOfFour() {
		incrementRandom(1);
		int actual = random.nextInt(4);
		int expected = 0;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testThirdIncrement_AnswerOutOfTwo() {
		incrementRandom(2);
		int actual = random.nextInt(2);
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}
}
