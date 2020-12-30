package org.ait.algorithms.knapsack;

//Java program to find maximum achievable
//value with a knapsack of weight W and
//multiple instances allowed.
public class UboundedKnapsack {

	private static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	// Returns the maximum value with knapsack
	// of W capacity
	private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {

		// dp[i] is going to store maximum value
		// with knapsack capacity i.
		int dp[] = new int[W + 1];

		// Fill dp[] using above recursive formula
		for (int i = 1; i <= W; i++) {
			for (int j = 0; j < n; j++) {
				if (wt[j] <= i) {
					dp[i] = max(dp[i], dp[i - wt[j]] + val[j]);
				}
			}
		}
		return dp[W];
	}

	// Driver program
	public static void main(String[] args) {
		int W = 0;
		//int val[] = { 10, 30, 20 };
		//int wt[] = { 5, 10, 15 };
		int[] wt = { 4, 3, 2, 1 };
		int[] val =  { 1, 10, 7, 3 };
		
		int n = val.length;
		System.out.println(unboundedKnapsack(W, n, val, wt));
	}
}