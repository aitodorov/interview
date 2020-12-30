package org.ait.algorithms.tree;

public class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
