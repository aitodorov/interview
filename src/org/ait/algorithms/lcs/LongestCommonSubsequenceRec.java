package org.ait.algorithms.lcs;

import java.util.ArrayList;
import java.util.Collections;

public class LongestCommonSubsequenceRec {
	static int numCalls = 0;
	static Result cache[][]; 
	
	static Result lcs(char[] array1, char[] array2, int idx1, int idx2) {
		numCalls++;
		if (idx1 == -1 || idx2 == -1)
			return Result.Empty;	
		
		if (cache[idx1][idx2] != null) {
			return cache[idx1][idx2];
		}
		
		if (array1[idx1] == array2[idx2]) {
			cache[idx1][idx2] = new Result(array1[idx1]).add(lcs(array1, array2, idx1 - 1, idx2 - 1));			
		}
		else {
			cache[idx1][idx2] = max(lcs(array1, array2, idx1, idx2 - 1), lcs(array1, array2, idx1 - 1, idx2));
		}
		return cache[idx1][idx2];
	}
	
	public static Result max(Result r1, Result r2) {
		if (r1 == null) {
			return r2;
		} else if (r2 == null) {
			return r1;
		} else {
			return (r1.len > r2.len) ? r1 : r2;
		}
	}

	public static void lcs(String s1, String s2) {
		cache = new Result[s1.length()][s2.length()];
		System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1));		
	}
	
	static class Result {
		static Result Empty = new Result();
		
		int len;
		ArrayList<Character> list = new ArrayList<>();
				
		private Result() {		
		}
		
		Result(char symbol) {
			list.add(new Character(symbol));
			len = 1;
		}
		
		public Result add(Result r) {
			if (r != null) {
				len += r.len;
				list.addAll(r.list);
			}		
			return this;
		}
		
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(len);
			str.append("\n");
			Collections.reverse(list);
			str.append(list);
			return str.toString();
		}
	}
}

