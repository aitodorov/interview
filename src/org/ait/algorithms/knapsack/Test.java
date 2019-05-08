package org.ait.algorithms.knapsack;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		int[] w = { 4, 3, 2, 1 };
		List<Integer> list = Arrays.stream(w).boxed().collect(Collectors.toList());
		System.out.println(list);
	}

}
