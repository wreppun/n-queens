package com.compilerworks.nqueens;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WikipediaATest {
	private Solver fixture = new WikipediaA();

	@Test
	public void nEqualsEight() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(8);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(TestUtils.expectedEight, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsNine() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(9);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(TestUtils.expectedNine, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsTen() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(10);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(TestUtils.expectedTen, oneIndexedSolutions.get(0));
	}
}
