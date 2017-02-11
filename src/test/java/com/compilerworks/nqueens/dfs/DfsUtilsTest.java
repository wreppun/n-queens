package com.compilerworks.nqueens.dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DfsUtilsTest {
	@Test
	public void getPossibles() {
		Set<Integer> possibles = DfsUtils.getPossibles(Collections.singletonList(0), 3);

		assertEquals(1, possibles.size());
		assertTrue(possibles.contains(2));

		// The 0 column excludes the 0, and 2 square on the 2 col
		// The 1 column excludes the 2, 3 and 4 square on the 2 col
		// This leaves only the 1 square on the 2 col;
		possibles = DfsUtils.getPossibles(Arrays.asList(0, 3), 5);

		assertEquals(1, possibles.size());
		assertTrue(possibles.contains(1));
	}
}
