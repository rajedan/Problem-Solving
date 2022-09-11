package ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class represents a un-directed Graph
 * Graph is represented by Adjacency List
 */
public class GraphAdjList {
	private int noOfVertex;
	private List<List<Integer>> graph;

	GraphAdjList(final int noOfVertex) {
		this.noOfVertex = noOfVertex;
		graph = new ArrayList<>(noOfVertex);
		for (int i = 0; i < noOfVertex; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int from, int to) {
		if (from >= noOfVertex ||
				to >= noOfVertex ||
				from < 0 ||
				to < 0)
			throw new RuntimeException("Invalid Vertex");

		graph.get(from).add(to);
		graph.get(to).add(from);
	}

	public void dfs() {
		boolean[] visitedNodes = new boolean[graph.size()];
		int unconnectedGraphs = 0;
		for (int i = 0; i < graph.size(); i++) {
			if (!visitedNodes[i]) {
				unconnectedGraphs++;
				this.dfsHelper(i, visitedNodes);
			}
		}
		System.out.print("unconnectedGraphs: " + unconnectedGraphs);
	}

	private void dfsHelper(int startNode, boolean[] visitedNodes) {
		visitedNodes[startNode] = Boolean.TRUE;
		System.out.print(startNode + " ");
		int idx = 0;
		for (int i = 0; i < graph.get(startNode).size(); i++) {
			int tempNode = graph.get(startNode).get(i);
			if (!visitedNodes[tempNode]) {
				dfsHelper(tempNode, visitedNodes);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < graph.size(); i++) {
			sb.append("\n[" + i + "]: " + graph.get(i));
		}
		return "GraphAdjList{" +
				"graph=" + sb.toString() +
				'}';
	}

	public static void main(String[] args) {
		GraphAdjList unDirectedGraph = new GraphAdjList(5);
		//unDirectedGraph.addEdge(1, 2);
		unDirectedGraph.addEdge(2, 3);
		unDirectedGraph.addEdge(1, 4);
		unDirectedGraph.addEdge(1, 3);
		unDirectedGraph.addEdge(3, 4);

		System.out.println(unDirectedGraph);

		unDirectedGraph.dfs();
	}
}
