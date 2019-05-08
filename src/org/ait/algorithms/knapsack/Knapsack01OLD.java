package org.ait.algorithms.knapsack;

public class Knapsack01OLD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] weights = { 4, 3, 2, 1 };
		int[] values =  { 1, 5, 4, 3 };
		
		int W = 6;
		for (W = 0; W <= 10; W++) {
		    System.out.println(W + ": " + knapSack(W, weights, values));
		}
	}

	static int knapSack(int W, int[] weights, int[] values) {
		int maxValues[][] = new int[values.length + 1][W + 1];

		for (int i = 1; i <= weights.length; i++) {
			for (int w = 1; w <= W; w++) {
				if (weights[i - 1] > w) {
					maxValues[i][w] = maxValues[i - 1][w];
				} else {
					maxValues[i][w] = Math.max(maxValues[i - 1][w],
							values[i - 1] + maxValues[i - 1][w - weights[i - 1]]);
				}
			}
		}
		//String.format("W=%s, max value=%s, selected weights=%s");
		return maxValues[values.length][W];
	}
	
	static String getSelectedWeights(int[][] maxValues) {
		StringBuilder result = new StringBuilder();
		return result.toString();
	}

}
