import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Tarjan {
    int timer = 0;
    private void dfs(Set<Integer> vis, int node, int parent, Map<Integer, List<Integer>> adj, List<int[]> bridges, int[] low, int[] tin) {
        vis.add(node);

        tin[node] = timer;
        low[node] = timer;

        timer++;

        for (int nei: adj.get(node)) {
            if (nei == parent) continue;
            else if (!vis.contains(nei)) {
                dfs(vis, nei, node, adj, bridges, low, tin);
                low[node] = Math.min(low[node], low[nei]);
                if (low[nei] > tin[node]) {
                    bridges.add(new int[]{node, nei});
                }
            }
            else {
                low[node] = Math.min(low[node], low[nei]);
            }
        }
    }

    public List<int[]> findBridges(Map<Integer, List<Integer>> adj, int V) {
        Set<Integer> vis = new HashSet<>();

        List<int[]> bridges = new ArrayList<>();

        int[] tin = new int[V];
        int[] low = new int[V];

        dfs(vis, 0, -1, adj, bridges, low, tin);

        return bridges;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap(){{
            put(0, new ArrayList<>(
                    Arrays.asList(1, 3)
            ));

            put(1, new ArrayList<>(
                    Arrays.asList(0, 2)
            ));

            put(2, new ArrayList<>(
                    Arrays.asList(1, 3)
            ));

            put(3, new ArrayList<>(
                    Arrays.asList(0, 4)
            ));

            put(4, new ArrayList<>(
                    Arrays.asList(3, 5)
            ));

            put(5, new ArrayList<>(
                    Arrays.asList(6, 8)
            ));

            put(6, new ArrayList<>(
                    Arrays.asList(5, 7)
            ));

            put(8, new ArrayList<>(
                    Arrays.asList(5, 7)
            ));

            put(7, new ArrayList<>(
                    Arrays.asList(6, 8, 9)
            ));

            put(9, new ArrayList<>(
                    Arrays.asList(7, 10, 11)
            ));

            put(10, new ArrayList<>(
                    Arrays.asList(9, 11)
            ));

            put(11, new ArrayList<>(
                    Arrays.asList(9, 10)
            ));
        }};

        Tarjan tarjan = new Tarjan();
        List<int[]> bridges = tarjan.findBridges(adj, 12);

        for (int i = 0; i < bridges.size(); i++) {
            System.out.println(bridges.get(i)[0] + "  " + bridges.get(i)[1]);
        }
    }
}