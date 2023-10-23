import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list representation

    public Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Perform Breadth-First Search starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[V]; // Mark all vertices as not visited
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            for (Integer neighbor : adjacencyList[startVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class BFSExample {
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.println("Breadth-First Traversal (starting from vertex 0):");
        graph.bfs(0);
    }
}
