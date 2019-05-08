package org.ait.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 3, 6, 5, 1, 11 };
		mergeSort(arr);
		System.out.println("sorted array: " + Arrays.toString(arr));
	}
	
	public static void mergeSort(int arr[]) {
		int temp[] = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
	}
	
	private static void mergeSort(int arr[], int[] temp, int l, int r) {
		if (l >= r) {
			return;
		}
	    
		int m = (l + r) / 2;
		mergeSort(arr, temp, l, m);
		mergeSort(arr, temp, m + 1, r);
		merge(arr, temp, l, m, r);	    
		
	}
	
	private static void merge(int arr[], int[] temp, int l, int m, int r) {
		for (int k = 0; k <= r; k++ ) {
			temp[k] = arr[k]; 
		}
		
		int i = l, j = m + 1;
		for (int k = l; k <= r; k++) {
			if (i > m) {
				arr[k] = temp[j++];				
			} else if (j > r) {
				arr[k] = temp[i++];				
			} else if (temp[i] < temp[j]) {
				arr[k] = temp[i++];
			} else {
				arr[k] = temp[j++];
			}
		}
	}

}
