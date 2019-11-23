import java.util.LinkedList;

/**
 * Created by ziad on 11/23/19.
 */
public  class Graph {
    static class graph {
        int V;
        LinkedList<Integer> adjListArray[];

        // constructor
        graph(int V) {
            this.V = V;

            // define the size of array as
            // number of vertices
            adjListArray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    // Adds an edge to an undirected graph
    static void addEdge(graph graph, int src, int dest) {
        // Add an edge from src to dest.
        graph.adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjListArray[dest].add(src);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }
}
