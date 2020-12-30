package org.ait.algorithms.tree;

import java.util.HashMap;

public class BottomView {
	
	static HashMap<Integer,NodeWrapper> bottomNodes = new HashMap<>();

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
		
		traverse(root, 0, 0);
		printSolution();
	}
	
	private static void traverse(Node node, int width, int depth) {
		if (node == null) {
			return;
		}	
		put(node, width, depth);
		traverse(node.left, width - 1, depth + 1);
		traverse(node.right, width + 1, depth + 1);
	}
	
	private static void put(Node node, int width, int depth) {
		NodeWrapper prevNodeWrapper = bottomNodes.get(width);
		if (prevNodeWrapper == null) {
			bottomNodes.put(width, new NodeWrapper(node, depth));						
		} else {
			NodeWrapper nodeWrapper = new NodeWrapper(node, depth);
			if (nodeWrapper.compareTo(prevNodeWrapper) >= 0) {
				bottomNodes.put(width, nodeWrapper);				
			}
		}
	}
	
	private static void printSolution() {
		for(int i : bottomNodes.keySet()) {
			System.out.println(bottomNodes.get(i).node);
		}
	}
	
	static class NodeWrapper implements Comparable<NodeWrapper> {
		Node node;
		int depth;
		NodeWrapper(Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
		@Override
		public int compareTo(NodeWrapper o) {
			return depth - o.depth;
		}
	}

}
