package org.ait.algorithms.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestCommonSubsequence {

	static int[][] lcs;
	
	public static void lcs(String s1, String s2) {
		lcs = new int[s1.length() + 1][s2.length()+1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = 1 + lcs[i-1][j-1]; 
				} else {
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);					
				}
			}
		}	
		System.out.println(lcs[s1.length()][s2.length()]);
		System.out.println(getSequence(s1));
		//System.out.println(Arrays.deepToString(lcs).replace("], ", "]\n").replace("[[", "[\n["));
	}
	
	static ArrayList getSequence(String s1) {
		ArrayList<Character> list = new ArrayList<>();
		int i = lcs.length - 1;
		int j = lcs[0].length -1;
		while ( i > 0 && j > 0 && lcs[i][j] != 0) {
			if (lcs[i][j] == lcs[i-1][j]) {
				i--;
			} else if (lcs[i][j] == lcs[i][j-1]) {
				j--;				
			} else {
				list.add(s1.charAt(i-1));		
				i--;
				j--;
			}
		}		
		Collections.reverse(list);
		return list;
	}
}
