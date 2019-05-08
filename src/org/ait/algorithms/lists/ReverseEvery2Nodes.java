package org.ait.algorithms.lists;

/**
 * 
 * Given a singly linked list, swap every 2 nodes, for odd number of input;
 * retain the last node as it is. Eg: Input: 5 13 15 18 20 11 6 7 Output: 13 5
 * 18 15 11 20 7 6
 *
 */
public class ReverseEvery2Nodes {

	public static void main(String[] args) {
		Node top = null;
		for (int i = 0; i <= 10; i++) {
			printNode(top);
			top = reverseEvery2Nodes(top, null, 1);
			printNode(top);
			top = swapEvery2NodesIter(top);
			printNode(top);
			System.out.println();

			Node n = new Node(i);
			n.next = top;
			top = n;
		}
	}

	static Node reverseEvery2Nodes(Node node, Node parent, int i) {
		if (node == null) {
			return null;
		}

		if (i % 2 == 0) {
			Node next = node.next;

			node.next = parent;
			parent.next = reverseEvery2Nodes(next, parent, i + 1);

			return node;
		} else {
			Node swapped = reverseEvery2Nodes(node.next, node, i + 1);
			return swapped == null ? node : swapped;
		}
	}

	static Node swapEvery2NodesIter(Node top) {
		int i = 1;
		Node result = top;
		Node current = top;
		Node prev = null;
		Node lastSwapped = null;

		while (current != null) {
			if (i == 1) {
				prev = current;
				current = current.next;
			} else {
				if (i % 2 == 0) {
					if (i == 2) {
						result = current;
					}

					Node next = current.next;

					current.next = prev;
					prev.next = next;
					if (lastSwapped != null) {
						lastSwapped.next = current;
					}
					lastSwapped = prev;

					current = next;
				} else {
					prev = current;
					current = current.next;
				}
			}
			i++;
		}
		return result;
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
