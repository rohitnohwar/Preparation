import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class BellmanFord {
    public void shortestPath(List<List<Integer>> edges, int V) {
        int[] dist = new int[V];
        int[] parent = new int[V];
        dist[0] = 0;
        for (int i = 1; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                int src = edges.get(j).get(0);
                int dest = edges.get(j).get(1);
                int weight = edges.get(j).get(2);

                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                    parent[dest] = src;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}