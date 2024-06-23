import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


class KruskalMinimumSpanningTree {
    private static int findParent(int v, int[] parent) {
        if (parent[v] == v) return v;

        return parent[v] = findParent(parent[v], parent);
    }

    private static void union(int[] parent, int[] rank, int u, int v) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (u == v) return;

        if (rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if (rank[u] > rank[v]) {
            parent[v] = u;
        }
        else {
            parent[u] = v;
            rank[v]++;
        }
    }

    public static void kruskal(List<int[]> edges, int V) {
        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });



        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        List<int[]> mst = new ArrayList<>();
        int weight = 0;

        for (int[] edge: edges) {
            if (findParent(edge[0], parent) != findParent(edge[1], parent)) {
                union(parent, rank, edge[0], edge[1]);
                weight += edge[2];
                mst.add(new int[]{edge[0], edge[1], edge[2]});
            }
        }

        System.out.println("Wieght:- " + weight);
        System.out.println(" ");

        for (int[] edge: mst) {
            System.out.println(edge[0] + "   ---->   " + edge[1] + "   =====   " + edge[2]);
        }

    }
}


public class Main {
    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<int[]>(
                Arrays.asList(
                        new int[]{0, 1, 10},
                        new int[]{0, 2, 6},
                        new int[]{0, 3, 5},
                        new int[]{1, 3, 15},
                        new int[]{2, 3, 4}
                        )
        );

        KruskalMinimumSpanningTree.kruskal(edges, 4);
    }
}