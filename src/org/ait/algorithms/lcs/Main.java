package org.ait.algorithms.lcs;

public class Main {

	public static void main(String[] args) {
		String s1 = "12345";
		//String s2 = "12yyy1245";
		String s2 = "xxxx1xxx";
		
		System.out.println("LongestCommonSubsequenceRec: ");
		LongestCommonSubsequenceRec.lcs(s1, s2);
		System.out.println("LongestCommonSubsequence: ");
		LongestCommonSubsequence.lcs(s1, s2);
	}

}
