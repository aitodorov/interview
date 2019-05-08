package org.ait.algorithms.lists;

/*
 * Given a linked list, write a program to reverse every k nodes
 */
public class ReverseListKNodes {

	public static void main(String[] args) {
		Node top = null;
		for (int i = 0; i < 11; i++) {
			Node n = new Node(i);
			n.next = top;
			top = n;
		}
		printNode(top);
		top = reverseEveryKnodes(top, 7);
		printNode(top);
	}
	
	static Node reverseEveryKnodes(Node node, int k) {
		Node newTopNode = null;
		Node bottomKReversed = null;
		
		while (true) {
			Node reversedKTop = null;
			Node currentBottomKReversed = null;
			for (int i = 0; i < k && node != null; i++) {
				if (i==0) {
					currentBottomKReversed = node;
				}
				Node popped = node;
				node = node.next;

				popped.next = reversedKTop;
				reversedKTop = popped;
			}
			
			if (bottomKReversed != null) {
				bottomKReversed.next = reversedKTop;
			}
			bottomKReversed = currentBottomKReversed;

			if (newTopNode == null) {
				newTopNode = reversedKTop;
			}
			
			if (node == null) {
				break;
			}		
		}		
		return newTopNode;	
	}
	
	static void printNode(Node n) {
		if (n == null) {
			System.out.println();
			return;
		}
		System.out.print(n.value + " ");
		printNode(n.next);
	}
}
