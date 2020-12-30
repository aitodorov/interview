package org.ait.algorithms.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeVerticalView {
	
	private static SortedMap<Integer,List<Node>> result = new TreeMap<>();

	public static void main(String[] args) {
		Node root = new Node(0);

		root.left = new Node(1);
		root.right = new Node(2);

		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);

		root.left.left.left = new Node(7);
		root.left.left.right = new Node(8);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(9);
		
		verticalView(root, 0);
		System.out.println(result);
	}
	
	private static void verticalView(Node node, int width) {
		if (node == null) {
			return;
		}
		putNode(node, width);
		verticalView(node.left, width - 1);
		verticalView(node.right, width + 1);
	}
	
	private static void putNode(Node node, int width) {
		List<Node> list = result.getOrDefault(width, new ArrayList());
		list.add(node);
		result.put(width, list);
	}
}
