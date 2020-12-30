package org.ait.algorithms.knapsack;

public class KnapasackUnbounded {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int W = 7;
		int[] weights = { 4, 3, 2, 1 };
		int[] values =  { 1, 10, 7, 3 };
		int[] maxValues = new int[W+1];
		for (int w = 1; w <= W; w++) {
			for (int i = 0; i < values.length; i++) {
				if (weights[i] <= w) {
					maxValues[w] = Math.max(values[i] + maxValues[w-weights[i]], maxValues[w]);
				}								
			}
		}
		System.out.println(maxValues[W]);
	}
}
