package com.compilerworks.nqueens;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUtils {
	public static void assertMatch(List<Integer> expected, List<Integer> solution) {
		assertEquals(expected.size(), solution.size());

		for (int i = 0; i < solution.size(); i++) {
			assertEquals(expected.get(i), solution.get(i));
		}
	}
}
