package com.compilerworks.nqueens.basic;

import com.compilerworks.nqueens.Solver;
import com.compilerworks.nqueens.TestUtils;
import com.compilerworks.nqueens.basic.WikipediaA;
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

		TestUtils.assertMatch(expectedEight, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsNine() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(9);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedNine, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsTen() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(10);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedTen, oneIndexedSolutions.get(0));
	}
}
