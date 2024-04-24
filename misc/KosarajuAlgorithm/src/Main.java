import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Kosaraju {
    private void dfs(int i, List<List<Integer>> adj, Set<Integer> vis, Stack<Integer> st) {
        vis.add(i);

        for (int neighbor: adj.get(i)) {
            if (!vis.contains(neighbor)) {
                dfs(neighbor, adj, vis, st);
            }
        }

        st.push(i);
    }

    private void revDfs(int i, List<List<Integer>> adjT, Set<Integer> vis, List<Integer> sccList) {
        vis.add(i);
        sccList.add(i);

        for (int neighbor: adjT.get(i)) {
            if (vis.contains(neighbor) == false) {
                revDfs(neighbor, adjT, vis, sccList);
            }
        }
    }

    public void findScc(List<List<Integer>> adj) {
        List<List<Integer>> res = new ArrayList<>();

        // vis is for keeping track of the visited nodes
        Set<Integer> vis = new HashSet<>();

        // Performing dfs almost similar to topological sort one
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (vis.contains(i) == false) {
                dfs(i, adj, vis, st);
            }
        }

        // adjT means adjTranspose
        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            for (int neighbor: adj.get(i)) {
                adjT.get(neighbor).add(i);
            }
        }

        vis = new HashSet<>();
        int sccCount = 0;
        while (!st.isEmpty()) {
            int i = st.pop();

            if (vis.contains(i) == false) {
                sccCount++;
                List<Integer> sccList = new ArrayList<>();
                revDfs(i, adjT, vis, sccList);
                res.add(sccList);
            }
        }

        System.out.println(res);
        System.out.println(sccCount);
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        adj.add(0, new ArrayList<>(Arrays.asList(1)));

        adj.add(1, new ArrayList<>(Arrays.asList(2)));

        adj.add(2, new ArrayList<>(Arrays.asList(0, 3)));

        adj.add(3, new ArrayList<>(Arrays.asList(4)));

        adj.add(4, new ArrayList<>(Arrays.asList(5, 7)));

        adj.add(5, new ArrayList<>(Arrays.asList(6)));

        adj.add(6, new ArrayList<>(Arrays.asList(4, 7)));

        adj.add(7, new ArrayList<>());



        Kosaraju k = new Kosaraju();
        k.findScc(adj);
    }
}
