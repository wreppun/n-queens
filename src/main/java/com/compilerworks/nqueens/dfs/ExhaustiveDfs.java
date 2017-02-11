package com.compilerworks.nqueens.dfs;

import com.compilerworks.nqueens.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.compilerworks.nqueens.Predicates.not;
import static java.util.stream.Collectors.toList;

/**
 * assumptions:
 * - board is in the first quadrant of an x-y axis graph
 * - we iterate through by incrementing x
 */
public class ExhaustiveDfs implements Solver {
	@Override
	public List<List<Integer>> solve(int n) {
		return descend(Collections.emptyList(), n);
	}

	private List<List<Integer>> descend(List<Integer> placements, int n) {
		// valid board
		if (placements.size() == n) {
			return Collections.singletonList(placements);
		}

		Set<Integer> possibles = DfsUtils.getPossibles(placements, n);

		// no more spots, done with this branch
		if (possibles.isEmpty()) {
			return Collections.emptyList();
		}

		// add each possible to the board, and pass to the next column
		return possibles.stream()
				.map(placement -> {
					List<Integer> withPlacement = new ArrayList<>(placements);
					withPlacement.add(placement);
					return withPlacement;
				})
				.map(possiblePlacement -> this.descend(possiblePlacement, n))
				.filter(not(List::isEmpty))
				.flatMap(List::stream)
				.collect(toList());
	}
}
