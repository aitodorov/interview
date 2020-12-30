package org.ait.algorithms.sorting;

import java.util.Arrays;

public class HeapSort {
	static void sort(int arr[]) {
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			heapify(arr, arr.length, i);

		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	/**
	 * creates max heap from a complete binary tree
	 * @param arr
	 *            array containing the tree to be heapified
	 * @param n
	 *            the length of the tree inside the the array
	 * @param i
	 *            index of the node that have to heapified
	 */
	static void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 7, 3, 6, 5, 1, 11 };
		sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}