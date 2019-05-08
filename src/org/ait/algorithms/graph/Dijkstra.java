package org.ait.algorithms.graph;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * function Dijkstra(Graph, source): {
 *   create vertex set Q
 *   for each vertex v in Graph: { // Initialization
 *   	dist[v] ← INFINITY         // Unknown distance from source to v
 *      prev[v] ← UNDEFINED        // Previous node in optimal path from source
 *      add v to Q                 // All nodes initially in Q (unvisited nodes)
 *   }
 *      
 *    dist[source] ← 0 // Distance from source to source
 *    
 *    while Q is not empty: {
 *    	u ← vertex in Q with min dist[u] // Node with the least distance will be selected first
 *    	remove u from Q
 *    	for each neighbor v of u: { // where v is still in Q.
 *    		alt ← dist[u] + length(u, v)
 *    		if alt < dist[v]: {  // A shorter path to v has been found
 *    			dist[v] ← alt
 *    			prev[v] ← u
 *    		}
 *       }
 *    }    
 *    return dist[], prev[]
 * }
 *    
 */
public class Dijkstra {

	public static void main(String[] args) {
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
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
			};		
 		dijkstra(graph, 0);
	}
	
	private static void dijkstra(int[][] graph, int sourceVertex) {
		int minDist[] = new int[graph.length];
		int prev[] = new int[graph.length];
		LinkedList<Integer> vertices = new LinkedList<>();
		
		for (int vertex = 0; vertex < minDist.length; vertex++) {
			minDist[vertex] = Integer.MAX_VALUE;
			prev[vertex] = -1;
			vertices.add(vertex);
		}
		
		minDist[sourceVertex] = 0;
		
		while (!vertices.isEmpty()) {
			int vertex = popMinDistanceVertex(vertices, minDist);
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
		
		printSolution(sourceVertex, minDist, prev);
	}
	
	private static int popMinDistanceVertex(LinkedList<Integer> vertices, int[] dist) {
		Integer min = vertices.get(0);		
		for (int i = 1; i < vertices.size(); i++) {
			if (dist[vertices.get(i)] < dist[min]) {
				min = vertices.get(i);
			}
		}		
		vertices.remove(min);		
		return min;
	}
	
	static void printSolution(int startVertex, int[] distances, int[] prev) {
		int nVertices = distances.length;
		System.out.print("Vertex\t Distance\tPath");

		for (int endVertex = 0; endVertex < nVertices; endVertex++) {
			if (endVertex != startVertex) {
				System.out.print(String.format("\n%d -> %d", startVertex, endVertex));
				
				if (distances[endVertex] == Integer.MAX_VALUE) {
					System.out.println("\t\tpath does not exist");
				} else {
					System.out.print(String.format(" \t\t %d\t\t", distances[endVertex]));
					printPath(endVertex, prev);					
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
