import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class Dijkstra {
    static void dijkstraShortestPath(Map<Integer, List<int[]>> adj, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        pq.add(new int[]{0, 0});

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int currNode = curr[0];
            int currDist = curr[1];

            if (visited[currNode] == true) continue;
            visited[currNode] = true;

            for (int[] nei: adj.get(currNode)) {
                int adjNode = nei[0];
                int adjDist = nei[1];

                if (visited[adjNode] == false) {
                    dist[adjNode] = currDist + adjDist;
                    parent[adjNode] = currNode;

                    pq.add(new int[]{adjNode, dist[adjNode]});

                }
            }
        }

//        For parent
//        0 parent:- 0
//        1 parent:- 0
//        2 parent:- 1
//        3 parent:- 2
//        4 parent:- 5
//        5 parent:- 6
//        6 parent:- 7
//        7 parent:- 0
//        8 parent:- 2
//
//
//        For distance
//        0 distance:- 0
//        1 distance:- 4
//        2 distance:- 12
//        3 distance:- 19
//        4 distance:- 21
//        5 distance:- 11
//        6 distance:- 9
//        7 distance:- 8
//        8 distance:- 14

        System.out.println("For parent");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " parent:- " + parent[i]);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("For distance");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " distance:- " + dist[i]);
        }
    }
}




public class Main {
    public static void main(String[] args) {
        int V = 9;
        Map<Integer, List<int[]>> graph
                = new HashMap<>();
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        graph.get(0).add(new int[]{1, 4});
        graph.get(0).add(new int[]{7, 8});
        graph.get(1).add(new int[]{2, 8});
        graph.get(1).add(new int[]{7, 11});
        graph.get(1).add(new int[]{0, 7});
        graph.get(2).add(new int[]{1, 8});
        graph.get(2).add(new int[]{3, 7});
        graph.get(2).add(new int[]{8, 2});
        graph.get(2).add(new int[]{5, 4});
        graph.get(3).add(new int[]{2, 7});
        graph.get(3).add(new int[]{4, 9});
        graph.get(3).add(new int[]{5, 14});
        graph.get(4).add(new int[]{3, 9});
        graph.get(4).add(new int[]{5, 10});
        graph.get(5).add(new int[]{4, 10});
        graph.get(5).add(new int[]{6, 2});
        graph.get(6).add(new int[]{5, 2});
        graph.get(6).add(new int[]{7, 1});
        graph.get(6).add(new int[]{8, 6});
        graph.get(7).add(new int[]{0, 8});
        graph.get(7).add(new int[]{1, 11});
        graph.get(7).add(new int[]{6, 1});
        graph.get(7).add(new int[]{8, 7});
        graph.get(8).add(new int[]{2, 2});
        graph.get(8).add(new int[]{6, 6});
        graph.get(8).add(new int[]{7, 1});


        Dijkstra.dijkstraShortestPath(graph, V);
    }
}