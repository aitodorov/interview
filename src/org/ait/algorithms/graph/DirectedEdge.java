package org.ait.algorithms.graph;

public class DirectedEdge {
	private int from;
	private int to;
	private int weight;
	
	DirectedEdge(int from, int to, int weight) {
		this.from = from;
		this.to= to;
		this.weight = weight;
	}
	
	int getFrom() {
		return from;
	}
	
	int getTo() {
		return to;
	}
	
	int getWeight() {
		return weight;
	}
	
}
