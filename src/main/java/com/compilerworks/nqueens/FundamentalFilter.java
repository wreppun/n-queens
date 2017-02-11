package com.compilerworks.nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pretty basic: rotate and flip each solution, and check if those rotations/flips have already
 * been seen.
 */
public final class FundamentalFilter {
	public static List<List<Integer>> distill(List<List<Integer>> solutions) {
		Set<String> keyedSolutions = new HashSet<>();

		List<List<Integer>> distilled = new ArrayList<>();

		solutions.forEach(solution -> {
			List<List<Integer>> rotations = getRotations(solution);
			List<List<Integer>> flipped = rotations.stream()
					.map(FundamentalFilter::reflect)
					.collect(Collectors.toList());

			List<String> keys = Stream.of(rotations, flipped)
					.flatMap(List::stream)
					.map(FundamentalFilter::toKey)
					.collect(Collectors.toList());

			if (keyedSolutions.addAll(keys)) {
				// found a new one
				distilled.add(solution);
			}
		});

		return distilled;
	}

	private static List<List<Integer>> getRotations(List<Integer> solution) {
		List<List<Integer>> rotations = new ArrayList<>();

		rotations.add(solution);

		List<Integer> rotated = solution;

		// rotate three times
		for (int i = 0; i < 3; i++) {
			rotated = rotate(rotated);
			rotations.add(rotated);
		}

		return rotations;
	}

	// with an n x n board in the first quadrant, rotate to the 4th quadrant by:
	// (x, y) -> (y, -x), and then translate back to the first quadrant by:
	// (x, y) -> (x, y + (n - 1)).
	//
	// so: (x, y) -> (y, -x + (n - 1))
	private static List<Integer> rotate(List<Integer> solution) {
		int n = solution.size();

		List<Integer> rotated = new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < n; i++) {
			// (n - 1) because 8 squares, but size 7 on graph axis
			rotated.set(solution.get(i), -i + (n - 1));
		}

		return rotated;
	}

	// reflecting across the diagonal is probably easiest
	private static List<Integer> reflect(List<Integer> solution) {
		int n = solution.size();

		List<Integer> flipped = new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < solution.size(); i++) {
			flipped.set(solution.get(i), i);
		}

		return flipped;
	}

	// We can use a simple string as a key?  Where the string is a concatenated set of comma-separated y values?
	// There's gotta be a better way.  Maybe a vector, or something using the difference between two adjacent cols?
	private static String toKey(List<Integer> solution) {
		return solution.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
	}

}
