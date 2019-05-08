package org.ait.algorithms.problems;

import java.util.List;

public class RotateMatrix {

	public static void main(String[] args) {
		int dimension = 5;
		int[][] matrix = creatematrix(dimension);
		print(matrix);
		rotateClockWise(matrix);
		System.out.println("rotated:");
		print(matrix);
	}

	private static void rotateClockWise(int[][] matrix) {
		int layers = matrix.length / 2;
		for (int i = 0; i < layers; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				int element1 = matrix[i][j];
				int element2 = matrix[j][matrix.length - 1 - i];
				int element3 = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
				int element4 = matrix[matrix.length - 1 - j][i];

				matrix[j][matrix.length - 1 - i] = element1;
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = element2;
				matrix[matrix.length - 1 - j][i] = element3;
				matrix[i][j] = element4;
			}
		}
	}

	private static int[][] creatematrix(int dimension) {
		int[][] result = new int[dimension][dimension];
		int value = 10;

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				result[i][j] = value++;
			}
		}
		return result;
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
