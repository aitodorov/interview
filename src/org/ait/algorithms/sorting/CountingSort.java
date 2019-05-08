package org.ait.algorithms.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// numbers are in the range [0..255]
		int a[] = { 34, 45, 15, 240, 139, 89, 212, 121, 44, 7, 8, 6, 5, 0, 1 };
		countingSort(a);
		System.out.println("Sorted array: " + Arrays.toString(a));
	}

	private static void countingSort(int[] a) {
		int count[] = new int [256];
		
		for(int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		
		int total = 0;
		for (int i = 0; i < count.length; i++) {
			int oldCount = count[i];
			count[i] = total;
			total += oldCount;
		}
		
		int temp[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			temp[count[a[i]]] = a[i];
			count[a[i]]++;
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}
	}
}
