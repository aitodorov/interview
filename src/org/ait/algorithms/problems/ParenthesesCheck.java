package org.ait.algorithms.problems;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesesCheck {
	
	private static HashMap<Character,Character> matchingBrackets = new HashMap<>();
	
	static {
		matchingBrackets.put('(', ')');
		matchingBrackets.put('[', ']');
		matchingBrackets.put('{', '}');
	}
	
	public static void main(String[] args) {
		String input = "(){[]}";
		System.out.println(checkBrackets(input));
	}
	
	private static boolean checkBrackets(String input) {
		char[] brackets = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char bracket : brackets) {
			if (isOpenBracket(bracket)) {
				stack.push(bracket);
			} else if (isCloseBracket(bracket)) {
				char openBracket = stack.pop();
				if (!checkMatch(openBracket, bracket)) {
					return false;
				}
			} else {
				System.out.println(stack);
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	private static boolean checkMatch(char openBracket, char closeBracket) {
		return matchingBrackets.getOrDefault(openBracket, ' ') == closeBracket;
		
	}
	
	private static boolean isOpenBracket(char bracket) {
		return bracket == '(' || bracket == '[' || bracket == '{';
	}

	private static boolean isCloseBracket(char bracket) {
		return bracket == ')' || bracket == ']' || bracket == '}';
	}

}
