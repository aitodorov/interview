package org.ait.algorithms.graph;

import java.util.ArrayList;

public class BellmanFord {

	public static void main(String[] args) throws Exception {
		int[][] graph = { 
				{ 0, 4, 0, 0, 0, 0, 0, 8, 0, 0 }, 
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0, 0 }, 
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2, 0 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 9, 0, 10, 0, 0, 0, 0 }, 
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6, 0 }, 
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7, 0 }, 
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
		
		belmanFord(graph, 0);
	}
	
	static void belmanFord(int[][] graph, int sourceVertex) throws Exception {
		int minDist[] = new int[graph.length];
		int prev[] = new int[graph.length];
		for (int vertex = 0; vertex < minDist.length; vertex++) {
			minDist[vertex] = Integer.MAX_VALUE;
			prev[vertex] = -1;			
		}		
		minDist[sourceVertex] = 0;
		
		for (int k = 0; k < graph.length - 1; k++) {			
			// According to Bellman-Ford definition here we should iterate over
			// the edges, but the edges are not directly accessible with adjacency matrix
			for (int vertex = 0; vertex < graph.length; vertex++) {
				int neighbors[] = graph[vertex];
				for(int i = 0; i < neighbors.length; i++) {
					int disti = neighbors[i];
					if (disti == 0) {
						continue; // no path from vertex to i
					}
					
					int alt = minDist[vertex] + disti; 
					if (alt < minDist[i]) {
						minDist[i] = alt;
						prev[i] = vertex;
					}
				}
			}			
		}	
		
		// TODO check negative cycles
		for (int vertex = 0; vertex < graph.length; vertex++) {
			int neighbors[] = graph[vertex];
			for(int i = 0; i < neighbors.length; i++) {
				int disti = neighbors[i];
				if (disti == 0) {
					continue; // no path from vertex to i
				}
				
				int alt = minDist[vertex] + disti; 
				if (alt < minDist[i]) {
					throw new Exception("negative cycle detected");
				}
			}
		}
		printSolution(sourceVertex, minDist, prev);
	}
	
	static void printSolution(int startVertex, int[] distances, int[] prev) {
		int nVertices = distances.length;
		System.out.print("Vertex\t Distance\tPath");

		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			if (vertexIndex != startVertex) {
				System.out.print(String.format("\n%d -> %d", startVertex, vertexIndex));
				
				if (distances[vertexIndex] == Integer.MAX_VALUE) {
					System.out.println("\t\tpath does not exist");
				} else {
					System.out.print(String.format(" \t\t %d\t\t", distances[vertexIndex]));
					printPath(vertexIndex, prev);					
				}				
			}
		} 
	} 
	
	static void printPath(int currentVertex, int[] prev) {
		ArrayList<Integer> path = new ArrayList<>();
		while (currentVertex != -1) {
			path.add(0, currentVertex);
			currentVertex = prev[currentVertex];
		}
		System.out.println(path);		
	}

}
