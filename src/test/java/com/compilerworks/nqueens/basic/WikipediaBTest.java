package com.compilerworks.nqueens.basic;

import com.compilerworks.nqueens.Solver;
import com.compilerworks.nqueens.TestUtils;
import com.compilerworks.nqueens.basic.WikipediaB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WikipediaBTest {
	private static List<Integer> expectedEight = Arrays.asList(2, 4, 6, 8, 3, 1, 7, 5);
	private static List<Integer> expectedFourteen = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 3, 1, 7, 9, 11, 13, 5);
	private static List<Integer> expectedFifteen = Arrays.asList(4, 6, 8, 10, 12, 14, 2, 5, 7, 9, 11, 13, 15, 1, 3);
	private static List<Integer> expectedTwenty = Arrays.asList( 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 3, 1, 7, 9, 11, 13, 15, 17, 19, 5);

	private Solver fixture = new WikipediaB();

	@Test
	public void nEqualsEight() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(8);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedEight, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsFourteen() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(14);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedFourteen, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsFifteen() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(15);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedFifteen, oneIndexedSolutions.get(0));
	}

	@Test
	public void nEqualsTwenty() {
		List<List<Integer>> oneIndexedSolutions = fixture.solveOneIndexed(20);

		assertEquals(1, oneIndexedSolutions.size());

		TestUtils.assertMatch(expectedTwenty, oneIndexedSolutions.get(0));
	}
}
