import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class FloydWarshall {
    public static void singleSourceShortestToAllVertices(List<List<Integer>> adjMatrix, int V) {
        List<List<Integer>> distMatrix = new ArrayList<>();

        for (int i = 0; i < adjMatrix.size(); i++) {
            distMatrix.add(new ArrayList<>());
            for (int j = 0; j < adjMatrix.get(0).size(); j++) {
                if (distMatrix.get(i).add(adjMatrix.get(i).get(j)));
            }
        }


        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (
                                    distMatrix.get(i).get(k) != Integer.MAX_VALUE &&
                                    distMatrix.get(k).get(j) != Integer.MAX_VALUE &&
                                    distMatrix.get(i).get(k) + distMatrix.get(k).get(j) < distMatrix.get(i).get(j)
                    ) {
                        distMatrix.get(i).set(j, distMatrix.get(i).get(k) + distMatrix.get(k).get(j));
                    }
                }
            }
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(distMatrix.get(i).get(j) + ",  ");
            }
            System.out.println("");
        }


    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> adjMatrix = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(0, 5, Integer.MAX_VALUE, 10),
                        Arrays.asList(Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE),
                        Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1),
                        Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0)
                )
        );

        FloydWarshall.singleSourceShortestToAllVertices(adjMatrix, 4);
    }
}