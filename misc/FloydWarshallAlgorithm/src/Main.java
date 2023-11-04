import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class FloydWarshall {
    public void allSourcesShortest(List<List<Integer>> adjMatrix, int V) {
        List<List<Integer>> distMatrix = adjMatrix;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distMatrix.get(i).set(j, adjMatrix.get(i).get(j));
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distMatrix.get(i).get(k) + distMatrix.get(k).get(j) < distMatrix.get(i).get(j)) {
                        distMatrix.get(i).set(j, distMatrix.get(i).get(k) + distMatrix.get(k).get(j));
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}