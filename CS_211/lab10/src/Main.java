import java.util.ArrayList;
import java.util.List;
package net.datastructures.*;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Vertex;


public class Main {
    public static void main(String[] args) {
        // create the graph
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");

        graph.insertEdge(graph.getVertex("A"), graph.getVertex("B"), 1);
        graph.insertEdge(graph.getVertex("A"), graph.getVertex("D"), 2);
        graph.insertEdge(graph.getVertex("B"), graph.getVertex("C"), 3);
        graph.insertEdge(graph.getVertex("B"), graph.getVertex("D"), 4);
        graph.insertEdge(graph.getVertex("C"), graph.getVertex("E"), 5);
        graph.insertEdge(graph.getVertex("D"), graph.getVertex("E"), 6);
        graph.insertEdge(graph.getVertex("D"), graph.getVertex("F"), 7);
        graph.insertEdge(graph.getVertex("E"), graph.getVertex("F"), 8);

        // traverse the graph using depth-first algorithm and print the visited vertices
        System.out.println("DFS Traversal:");
        GraphAlgorithms.depthFirstSearch(graph, graph.getVertex("A"), v -> {
            System.out.println(v.getElement());
        });

        // print the vertices along the path
        List<Vertex<String>> path = new ArrayList<>();

        GraphAlgorithms.depthFirstSearch(graph, graph.getVertex("A"), v -> {
            path.add(v);
        });

        System.out.print("Path: ");
        for (Vertex<String> v : path) {
            System.out.print(v.getElement() + " ");
        }
    }
}
