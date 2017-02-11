package com.compilerworks.nqueens;

import java.util.function.Predicate;

public final class Predicates {
	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	public static boolean isOdd(int n) {
		return n % 2 == 1;
	}

	public static <T> Predicate<T> not(Predicate<T> isSomething) {
		return input -> !isSomething.test(input);
	}


}
