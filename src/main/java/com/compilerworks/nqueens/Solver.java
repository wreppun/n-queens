package com.compilerworks.nqueens;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface Solver {
	List<List<Integer>> solve(int n);

	// add one to every integer to 1-index it
	default List<List<Integer>> solveOneIndexed(int n) {
		return solve(n).stream()
				.map(solution -> solution.stream().map(k -> k+1).collect(toList()))
				.collect(toList());
	}
}
