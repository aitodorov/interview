package org.ait.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 4, 17, 11, 9, 6, 7 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("sorted array: " + Arrays.toString(arr));
	}

	private static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pivotIdx = partition(arr, low, high);
			quickSort(arr, low, pivotIdx - 1);
			quickSort(arr, pivotIdx + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int lastLesserValueIdx = low - 1;

		for (int i = low; i <= high - 1; i++) {
			if (arr[i] < pivot) {
				lastLesserValueIdx++;
				swap(arr, lastLesserValueIdx, i);
			}
		}

		swap(arr, lastLesserValueIdx + 1, high);

		return lastLesserValueIdx + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;

	}

}
