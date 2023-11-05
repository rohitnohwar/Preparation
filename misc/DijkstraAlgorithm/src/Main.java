import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Dijkstra {
    public int[] findShortest(Map<Integer, List<int[]>> adj, int V, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        parent[src] = src;

        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int currNode = top[0];
            int currDist = top[1];

            for (int[] nei: adj.get(currNode)) {
                int adjNode = nei[0];
                int adjDist = nei[1];

                if (currDist + adjDist < dist[adjNode]) {
                    dist[adjNode] = currDist + adjDist;
                    parent[adjNode] = currNode;
                    pq.add(new int[]{adjNode, dist[adjNode]});
                }
            }
        }

        return dist;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}