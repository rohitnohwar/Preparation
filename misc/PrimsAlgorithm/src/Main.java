import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Prim {
    public void mst(Map<Integer, List<int[]>> adj, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<Integer> vis = new HashSet<>();

        pq.add(new int[]{0, 0, -1});

        int sum = 0;
        List<int[]> mst = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] top = pq.remove();

            int node = top[0];
            int wt = top[2];
            int par = top[1];

            if (vis.contains(node)) continue;

            vis.add(node);

            sum += wt;
            mst.add(top);

            for (int[] nei: adj.get(node)) {
                if (!vis.contains(nei[0])) {
                    int adjNode = nei[0];
                    int adjWt = nei[1];
                    pq.add(new int[]{adjNode, node, adjWt});
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
    }
}