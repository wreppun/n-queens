package com.compilerworks.nqueens;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUtils {
	public static List<Integer> expectedEight = Arrays.asList(4, 6, 8, 2, 7, 1, 3, 5);
	public static List<Integer> expectedNine = Arrays.asList(4, 6, 8, 2, 7, 1, 3, 5, 9);
	public static List<Integer> expectedTen = Arrays.asList(2, 4, 6, 8, 10, 1, 3, 5, 7, 9);

	public static void assertMatch(List<Integer> expected, List<Integer> solution) {
		assertEquals(expected.size(), solution.size());

		for (int i = 0; i < solution.size(); i++) {
			assertEquals(expected.get(i), solution.get(i));
		}
	}
}
