package com.compilerworks.nqueens;

import com.compilerworks.nqueens.dfs.ExhaustiveDfs;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FundamentalFilterTest {

	private static List<Long> fundamentalSolutionsCount = Arrays.asList(
			0L,
			1L,
			0L,
			0L,
			1L,
			2L,
			1L,
			6L,
			12L,
			46L,
			92L,
			341L,
			1787L,
			9233L,
			45752L,
			285053L,
			1846955L,
			11977939L,
			83263591L,
			621012754L,
			4878666808L,
			39333324973L,
			336376244042L,
			3029242658210L,
			28439272956934L,
			275986683743434L,
			2789712466510289L,
			29363495934315694L
	);

	private Solver solver = new ExhaustiveDfs();

	@Test
	public void fundamentalSolutionsCount() {
		List<List<Integer>> distilled;

		for (int i = 1; i < 14; i++) {
			long start = System.currentTimeMillis();

			distilled = FundamentalFilter.distill(solver.solve(i));

			System.out.println(String.format("finished in %d ms", System.currentTimeMillis() - start));
			assertEquals(String.format("failed at %d queens", i), (long) fundamentalSolutionsCount.get(i), distilled.size());
		}
	}
}
