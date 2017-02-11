package com.compilerworks.nqueens.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DfsUtils {
	// Assumes that the existing placements are in the columns 0 -> (k-1), and we're looking
	// for possibles in the k column;
	//
	// Intuitively seems faster than an isSafe check on each column square.
	// Assuming that each placement removes at least one square from the subsequent column (valid assumption?)
	// that means that there will at least be one check in the subsequent row that will fail on (column - 2) and one
	// that will fail on (column - 1), giving O(n)^2. This is still O(n).  Probably still faster ways possible though.
	public static Set<Integer> getPossibles(List<Integer> existing, int n) {
		HashSet<Integer> possibles = IntStream.range(0, n).boxed().collect(Collectors.toCollection(HashSet::new));

		int nextColumn = existing.size();

		for (int i = 0; i < existing.size(); i++) {
			possibles.removeAll(excluded(i, existing.get(i), nextColumn, n));
		}

		return possibles;
	}

	private static Set<Integer> excluded(int x, int y, int targetCol, int n) {
		Set<Integer> excluded = new HashSet<>();

		// always exclude the horizontal row
		excluded.add(y);

		int diagonalDifference = targetCol - x;

		// exclude the positive diagrnal if >= n
		if (y + diagonalDifference < n) {
			excluded.add(y + diagonalDifference);
		}

		// exclude the negative diagonal if < 0
		if (y - diagonalDifference >= 0) {
			excluded.add(y - diagonalDifference);
		}

		return excluded;
	}
}
