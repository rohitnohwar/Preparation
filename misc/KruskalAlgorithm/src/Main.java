import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Kruskal {
    private int findParent(int u, int[] parent) {
        if (u == parent[u]) {
            return u;
        }

        return parent[u] = findParent(u, parent);
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (u == v) return false;

        if (rank[u] > rank[v]) {
            parent[v] = u;
        }
        else if (rank[u] < rank[v]) {
            parent[u] = v;
        }
        else {
            parent[u] = v;
            rank[v]++;
        }

        return true;
    }

    public void mst(Map<Integer, List<int[]>> adj, int V) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        Set<Integer> vis = new HashSet<>();

        List<int[]> edges = new ArrayList<>();

        for (Map.Entry<Integer, List<int[]>> m: adj.entrySet()) {
            for (int[] arr: m.getValue()) {
                edges.add(new int[]{m.getKey(), arr[0], arr[1]});
            }
        }

        edges.sort((a, b) -> a[2] - b[2]);

        int mstWt = 0;
        List<int[]> mst = new ArrayList<>();
        for (int[] edge: edges) {
            if (findParent(edge[0], parent) != findParent(edge[1], parent)) {
                union(edge[0], edge[1], parent, rank);
                mstWt += edge[2];
                mst.add(new int[]{edge[0], edge[1]});
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
    }
}