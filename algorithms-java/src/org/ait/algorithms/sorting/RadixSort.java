package org.ait.algorithms.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int a[] = { 111, 4, 1, 62, 66, 65, 67, 800, 7, 8, 61, 33, 31 };

		radixSort(a);

		System.out.println("Sorted array: " + Arrays.toString(a));

	}

	static void radixSort(int[] a) {
		int tempArr[] = new int[a.length];
		int max = getMax(a);

		for (int digitPos = 1; max / digitPos > 0; digitPos *= 10) {
			int count[] = new int[10];

			for (int i = 0; i < a.length; i++) {
				count[(a[i] / digitPos) % 10]++;
			}

			// convert count from array containing counts to
			// array containing offsets in the sorted array
			int total = 0;
			for (int i = 0; i < 10; i++) {
				int oldCount = count[i];
				count[i] = total;
				total += oldCount;
			}

			for (int i = 0; i < a.length; i++) {
				int digit = (a[i] / digitPos) % 10;
				tempArr[count[digit]] = a[i];
				count[digit]++;
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = tempArr[i];
			}

			System.out.println(String.format("Sorted array for pos %d: %s", digitPos, Arrays.toString(a)));
		}
	}

	static int getMax(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

}
