package org.ait.algorithms.maxsubarray;

public class Kadane {

	public static void main(String[] args) {
		//int[] a = { -2, -3, 5, 5, -5, -4, 10 };
		int[] a = { -100, 50, -5, -5, 50, -100 };
		System.out.println("Maximum contiguous subarray sum: " + maxSubArraySum(a));
		System.out.println("Maximum contiguous subarray sum: " + maxSubArraySum1(a));
	}

	static int maxSubArraySum(int a[]) {
		int max, maxEndingHere;
		max = maxEndingHere = a[0];

		for (int i = 1; i < a.length; i++) {
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			maxEndingHere += a[i];

			if (maxEndingHere > max) {
				max = maxEndingHere;
			}
		}
		return max;
	}
	
	static int maxSubArraySum1(int a[]) {
		int max, maxEndingHere;
		max = maxEndingHere = a[0];

		for (int i = 1; i < a.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + a[i], a[i]);
			max = Math.max(maxEndingHere, max);
		}
		return max;
	}

}
