package com.compilerworks.nqueens.basic;

import com.compilerworks.nqueens.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.compilerworks.nqueens.Predicates.isEven;

/**
 * The examples above can be obtained with the following formulas. Let (i, j) be the square in column i and row j on the n × n chessboard, k an integer.
 *
 * If n is even and n ≠ 6k + 2, then place queens at (i, 2i) and (n/2 + i, 2i - 1) for i = 1, 2, ..., n / 2.
 * If n is even and n ≠ 6k, then place queens at (i, 1 + (2i + n/2 - 3 (mod n))) and (n + 1 - i, n - (2i + n/2 - 3 (mod n))) for i = 1, 2, ..., n / 2.
 * If n is odd, then use one of the patterns above for (n − 1) and add a queen at (n, n).
 */
public class WikipediaA implements Solver {

	@Override
	public List<List<Integer>> solve(int n) {
		return Collections.singletonList(singleSolution(n));
	}

	private List<Integer> singleSolution(int n) {
		List<Integer> solution = new ArrayList<>(Collections.nCopies(n, 0));

		if (isEven(n) && n % 6 != 2) {
			for (int i = 1; i <= n / 2; i++) {
				solution.set(i - 1, 2 * i - 1);
				solution.set(n / 2 + i - 1, 2 * i - 2);
			}
		} else if (isEven(n) && n % 6 != 0) {
			for (int i = 1; i <= n / 2; i++) {
				solution.set(i - 1, (2 * i + n / 2 - 3) % n);
				solution.set(n - i, (n - 1) - (2 * i + n / 2 - 3) % n);
			}
		} else {
			solution = singleSolution(n - 1);
			solution.add(n - 1);
		}

		return solution;
	}
}
