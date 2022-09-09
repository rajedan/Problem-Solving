package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents an un-directed graph
 */
public class GraphAdjMat {

	private int noOfVertex; // Represents Number of Vertices in graph
	private int[][] mat;

	GraphAdjMat(final int noOfVertex) {
		this.noOfVertex = noOfVertex;
		mat = new int[noOfVertex][noOfVertex];
	}

	public void addEdge(int from, int to) {
		if (from >= noOfVertex ||
				to >= noOfVertex ||
				from < 0 ||
				to < 0)
			throw new RuntimeException("Invalid vertex");
		mat[from][to] = 1;
		mat[to][from] = 1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] ints : mat) {
			sb.append("\n" + Arrays.toString(ints));
		}
		return "GraphAdjMat{" +
				"mat=" + sb.toString() +
				'}';
	}

	public static void main(String[] args) {
		GraphAdjMat unDirectedGraph = new GraphAdjMat(5);
		unDirectedGraph.addEdge(1, 2);
		unDirectedGraph.addEdge(2, 3);
		unDirectedGraph.addEdge(1, 4);
		System.out.println(unDirectedGraph);
	}
}
