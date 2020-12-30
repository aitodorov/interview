package org.ait.algorithms.tree;

import java.util.HashMap;

public class MaxLevelSum {
	
	private static HashMap<Integer,Integer> maxLevelSum = new HashMap<>();

	public static void main(String[] args) {
		Node root = new Node(0);
		root.right = new Node(1);
		root.right.right = new Node(2);
		root.right.right.right = new Node(3);
		root.right.right.left = new Node(4);
		root.right.right.left.left = new Node(10);
		root.right.right.left.right = new Node(5);
		root.left = new Node(6);
		root.right.left = new Node(7);
		
		maxLevelSum(0, root);		
		System.out.println(maxLevelSum);
		
	}
	
	public static void maxLevelSum(int level, Node node) {
		if (node == null) {
			return;
		}
		
		Integer levelSum = maxLevelSum.getOrDefault(level, 0);
		maxLevelSum.put(level, levelSum + node.value);		
		
		maxLevelSum(level + 1, node.left);
		maxLevelSum(level + 1, node.right);
	}

}
