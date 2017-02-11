package com.compilerworks.nqueens;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WikipediaATest {
	private static List<Integer> expectedEight = Arrays.asList(4, 6, 8, 2, 7, 1, 3, 5);
	private static List<Integer> expectedNine = Arrays.asList(4, 6, 8, 2, 7, 1, 3, 5, 9);
	private static List<Integer> expectedTen = Arrays.asList(2, 4, 6, 8, 10, 1, 3, 5, 7, 9);

	private Solver fixture = new WikipediaA();

	@Test
	public void nEqualsEight() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(8);

		assertEquals(1, oneIndexedSolutions.size());

		assertMatch(expectedEight, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsNine() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(9);

		assertEquals(1, oneIndexedSolutions.size());

		assertMatch(expectedNine, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsTen() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(10);

		assertEquals(1, oneIndexedSolutions.size());

		assertMatch(expectedTen, oneIndexedSolutions.get(0));
	}

	private static void assertMatch(List<Integer> expected, List<Integer> solution) {
		assertEquals(expected.size(), solution.size());

		for (int i = 0; i < solution.size(); i++) {
			assertEquals(expected.get(i), solution.get(i));
		}
	}
}
