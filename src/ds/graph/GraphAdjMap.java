package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjMap<T> {
	private int noOfVertex;
	private Map<T, List<T>> bucket;

	GraphAdjMap() {
		bucket = new HashMap<>();
	}

	public void addVertex(final T vertex) {
		if (bucket.containsKey(vertex))
			throw new RuntimeException("Vertex already present in graph");
		bucket.put(vertex, new ArrayList<T>());
		noOfVertex++;
	}

	public void addEdge(final T from, final T to) {
		if (!bucket.containsKey(from) ||
				!bucket.containsKey(to))
			throw new RuntimeException("Unknown vertex, Add the vertex into graph");
		bucket.get(from).add(to);
		bucket.get(to).add(from);
	}

	public int getNoOfVertex() {
		return noOfVertex;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		bucket.forEach((k, v) -> sb.append("\n[" + k + "]: " + v));

		return "GraphAdjMap{" +
				"bucket=" + sb.toString() +
				'}';
	}

	public static void main(String[] args) {
		GraphAdjMap<Integer> graph = new GraphAdjMap<Integer>();
		graph.addVertex(3);
		graph.addVertex(5);
		graph.addVertex(7);
		graph.addVertex(9);

		graph.addEdge(3, 7);
		graph.addEdge(3, 9);
		graph.addEdge(7, 5);

		System.out.println(graph);
	}
}
