package org.ait.algorithms.knapsack;

public class Knapsack01 {

	public static void main(String[] args) {

		int[] weights = { 4, 3, 100, 2, 1 };
		int[] values = { 1, 5, 100, 4, 3 };

		for (int knapSackCapacity = 0; knapSackCapacity <= 10; knapSackCapacity++) {
			System.out.println(knapSackCapacity + ": " + knapSack(knapSackCapacity, weights, values));
		}
	}

	static int knapSack(int knapSackCapacity, int[] weights, int[] values) {
		int m[][] = new int[values.length][knapSackCapacity + 1];

		for (int i = 0; i < weights.length; i++) {
			for (int currentWeightLimit = 1; currentWeightLimit <= knapSackCapacity; currentWeightLimit++) {
				if (i == 0) {
					m[i][currentWeightLimit] = (weights[i] > currentWeightLimit) ? 0 : values[i];
				} else if (weights[i] > currentWeightLimit) {
					m[i][currentWeightLimit] = m[i - 1][currentWeightLimit];
				} else {
					m[i][currentWeightLimit] = Math.max(m[i - 1][currentWeightLimit],
							values[i] + m[i - 1][currentWeightLimit - weights[i]]);
				}
			}
		}

		return m[values.length - 1][knapSackCapacity];
	}
}
