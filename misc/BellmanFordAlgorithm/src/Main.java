import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class BellmanFordShortestPath {
    public static void shortestPath(List<int[]> edges, int V) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < V; i++) {
            for (int[] edge: edges) {
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];

                if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
                    distance[dest] = distance[src] + weight;
                    parent[dest] = src;
                }
            }
        }

        for (int i = 0; i < parent.length; i++) {
            System.out.println(parent[i] + "   ----->   " + i);
        }

        System.out.println(" ");

        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "   ----->   " + distance[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        List<int[]> edges = new ArrayList<>(
                Arrays.asList(
                        new int[]{0, 1, -1},
                        new int[]{0, 2, 4},
                        new int[]{1, 2, 3},
                        new int[]{1, 3, 2},
                        new int[]{1, 4, 2},
                        new int[]{3, 2, 5},
                        new int[]{3, 1, 1},
                        new int[]{4, 3, -3}
                )
        );

        BellmanFordShortestPath.shortestPath(edges, 5);

    }
}