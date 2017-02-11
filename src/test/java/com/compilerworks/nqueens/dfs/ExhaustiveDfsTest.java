package com.compilerworks.nqueens.dfs;

import com.compilerworks.nqueens.Solver;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExhaustiveDfsTest {
	private static List<Long> allSolutionsCount = Arrays.asList(
			0L,
			1L,
			0L,
			0L,
			2L,
			10L,
			4L,
			40L,
			92L,
			352L,
			724L,
			2680L,
			14200L,
			73712L,
			365596L,
			2279184L,
			14772512L,
			95815104L,
			666090624L,
			4968057848L,
			39029188884L,
			314666222712L,
			2691008701644L,
			24233937684440L,
			227514171973736L,
			2207893435808352L,
			22317699616364044L,
			234907967154122528L);

	private Solver fixture = new ExhaustiveDfs();


	@Test
	public void exhaustiveSolutions() {
		int n = 0;

		List<List<Integer>> solutions;

		solutions = fixture.solve(n);

		System.out.println(solutions);

		long count = solutions.size();
		long expected = allSolutionsCount.get(n);

		assertEquals(expected, count);
	}

	@Test
	public void exhaustiveSolutionsCount() {
		List<List<Integer>> solutions;

		for (int i = 1; i < 15; i++) {
			long start = System.currentTimeMillis();

			solutions = fixture.solve(i);

			System.out.println(String.format("finished in %d ms", System.currentTimeMillis() - start));
			assertEquals(String.format("failed at %d queens", i), (long) allSolutionsCount.get(i), solutions.size());
		}
	}
}
