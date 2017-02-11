package com.compilerworks.nqueens.basic;

import com.compilerworks.nqueens.Predicates;
import com.compilerworks.nqueens.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * 1. If the remainder from dividing N by 6 is not 2 or 3 then the list is simply all even numbers followed by all odd numbers not greater than N.
 * 2. Otherwise, write separate lists of even and odd numbers (i. e. 2, 4, 6, 8 — 1, 3, 5, 7).
 * 3. If the remainder is 2, swap 1 and 3 in odd list and move 5 to the end (i. e. 3, 1, 7, 5).
 * 4. If the remainder is 3, move 2 to the end of even list and 1,3 to the end of odd list (i. e. 4, 6, 8, 2 — 5, 7, 1, 3).
 * 5. Append odd list to the even list and place queens in the rows given by these numbers, from left to right (i. e. a2, b4, c6, d8, e3, f1, g7, h5).
 */
public class WikipediaB implements Solver {

	@Override
	public List<List<Integer>> solve(int n) {
		return Collections.singletonList(singleSolution(n));
	}

	private List<Integer> singleSolution(int n) {
		List<Integer> solution = new ArrayList<>();

		int remainder = n % 6;

		List<Integer> evens = evensLessThanN(n);
		List<Integer> odds = oddsLessThanN(n);

		if (remainder == 2) {
			swapInList(odds, 0, 1); // swap 1, 3
			moveToEnd(odds, 2); // move 5
		} else if (remainder == 3) {
			moveToEnd(evens, 0); // move 2
			moveToEnd(odds, 0); // move 1
			moveToEnd(odds, 0); // move 3
		}

		solution.addAll(evens);
		solution.addAll(odds);

		return solution.stream().map(k -> k - 1).collect(toList());
	}

	private static List<Integer> evensLessThanN(int n) {
		return numbersLessThanN(Predicates::isEven, n);
	}

	private static List<Integer> oddsLessThanN(int n) {
		return numbersLessThanN(Predicates::isOdd, n);
	}

	private static List<Integer> numbersLessThanN(IntPredicate filter, int n) {
		return IntStream.range(1, n + 1)
				.filter(filter)
				.boxed()
				.collect(toList());
	}

	private static <T> void swapInList(List<T> things, int leftIdx, int rightIdx) {
		T leftThing = things.get(leftIdx);
		things.set(leftIdx, things.get(rightIdx));
		things.set(rightIdx, leftThing);
	}

	private static <T> void moveToEnd(List<T> things, int i) {
		T thing = things.remove(i);
		things.add(thing);
	}
}
