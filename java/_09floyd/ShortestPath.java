package _09floyd;

public class ShortestPath {

    private static final int INF = 65535;

    public static void main(String[] args) {
        // 顶点集
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        // 边集
        int[][] matrix = new int[vertex.length][vertex.length];

        matrix[0] = new int[] { 0, 5, 7, INF, INF, INF, 2 };
        matrix[1] = new int[] { 5, 0, INF, 9, INF, INF, 3 };
        matrix[2] = new int[] { 7, INF, 0, INF, 8, INF, INF };
        matrix[3] = new int[] { INF, 9, INF, 0, INF, 4, INF };
        matrix[4] = new int[] { INF, INF, 8, INF, 0, 5, 4 };
        matrix[5] = new int[] { INF, INF, INF, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, INF, INF, 4, 6, 0 };

        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }

}
