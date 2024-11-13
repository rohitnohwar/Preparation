import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class Prim {
    public static void mst(Map<Integer, List<int[]>> adj, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int[] weight = new int[V];
        for (int i = 0; i < V; i++) weight[i] = Integer.MAX_VALUE;
        weight[0] = 0;

        int sum = 0;

        pq.add(new int[]{0, 0});

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int currNode = curr[0];kl
            int currDist = curr[1];

            if (visited[currNode] == true) continue;
            visited[currNode] = true;

            sum += currDist;

            for (int[] nei: adj.get(currNode)) {
                int adjNode = nei[0];
                int adjDist = nei[1];

                if (visited[adjNode] == false && adjDist < weight[adjNode]) {
                    weight[adjNode] = adjDist;
                    parent[adjNode] = currNode;
                    pq.add(new int[]{adjNode, adjDist});
                }
            }
        }

        System.out.println(sum);

        for (int i = 0; i < V; i++) {
            System.out.println(parent[i] + " :- " + i);
        }

        //Commented out code could be used to reconstruct the minimum spanning tree by points with weight
    }
}


public class Main {
    public static void main(String[] args) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < 9; i++) graph.put(i, new ArrayList<int[]>());

        graph.get(0).add(new int[]{1, 4});
        graph.get(1).add(new int[]{0, 4});

        graph.get(0).add(new int[]{7, 8});
        graph.get(7).add(new int[]{0, 8});

        graph.get(1).add(new int[]{ 2, 8});
        graph.get(2).add(new int[]{1, 8});

        graph.get(1).add(new int[]{ 7, 11});
        graph.get(7).add(new int[]{1, 11});

        graph.get(2).add(new int[]{ 3, 7});
        graph.get(3).add(new int[]{2, 7});

        graph.get(2).add(new int[]{ 8, 2});
        graph.get(8).add(new int[]{2, 2});

        graph.get(2).add(new int[]{ 5, 4});
        graph.get(5).add(new int[]{2, 4});

        graph.get(3).add(new int[]{ 4, 9});
        graph.get(4).add(new int[]{3, 9});

        graph.get(3).add(new int[]{ 5, 14});
        graph.get(5).add(new int[]{3, 14});

        graph.get(4).add(new int[]{ 5, 10});
        graph.get(5).add(new int[]{4, 10});

        graph.get(5).add(new int[]{ 6, 2});
        graph.get(6).add(new int[]{5, 2});

        graph.get(6).add(new int[]{ 7, 1});
        graph.get(7).add(new int[]{6, 1});

        graph.get(6).add(new int[]{ 8, 6});
        graph.get(8).add(new int[]{6, 6});

        graph.get(7).add(new int[]{ 8, 7});
        graph.get(8).add(new int[]{7, 7});

        Prim.mst(graph, 9);

    }
}