package org.ait.algorithms.rodcutting;

/**
 * this is the algorithm if values and maxRodValue arrays start from index 1:
 * 
 * maxRodValue(1) = values[1]
 * maxRodValue(2) = max(value[2], maxRodValue(1))
 * maxRodValue(3) = max(value[3], maxRodValue(2) + maxRodValue(1) )
 * maxRodValue(4) = max(value[4], maxRodValue(3) + maxRodValue(1), maxRodValue(2) + maxRodValue(2))
 * maxRodValue(5) = max(value[5], maxRodValue(4) + maxRodValue(1), maxRodValue(3) + maxRodValue(2))
 * maxRodValue(6) = max(value[6], maxRodValue(5) + maxRodValue(1), maxRodValue(4) + maxRodValue(2), maxRodValue(3) + maxRodValue(3))
 * maxRodValue(7) = max(value[7], maxRodValue(6) + maxRodValue(1), maxRodValue(5) + maxRodValue(2), maxRodValue(4) + maxRodValue(3))
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] values = {0,6,1,1,1,2,3};
		int[] maxRodValue = new int[values.length];
		
		for (int length = 1; length <= values.length; length++) {
			if (length == 1) {
				maxRodValue[0] = values[0];				
			} else {
				int max = values[length - 1];
				for (int j = length - 1; j >= length / 2; j--) {
					max = Math.max(max, maxRodValue[j - 1] + maxRodValue[length - j - 1]);															
				}
				maxRodValue[length - 1] = max;	
			}
		}
		
		System.out.println(maxRodValue[maxRodValue.length - 1]);
	}
}
