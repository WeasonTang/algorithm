package _08dijkstra;

public class ShortestPath {

    private static final int INF = 65535;

    public static void main(String[] args) {
        // 顶点集
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' , 'H'};
        // 边集
        int[][] matrix = new int[vertex.length][vertex.length];

        matrix[0] = new int[] { INF, 5, 7, INF, INF, INF, 2, 8 };
        matrix[1] = new int[] { 5, INF, INF, 9, INF, INF, 3, INF };
        matrix[2] = new int[] { 7, INF, INF, INF, 8, INF, INF, INF };
        matrix[3] = new int[] { INF, 9, INF, INF, INF, 4, INF, INF };
        matrix[4] = new int[] { INF, INF, 8, INF, INF, 5, 4, INF };
        matrix[5] = new int[] { INF, INF, INF, 4, 5, INF, 6, INF };
        matrix[6] = new int[] { 2, 3, INF, INF, 4, 6, INF, INF };
        matrix[7] = new int[] { 8, INF, INF, INF, INF, INF, INF, INF };

        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();

        graph.dijkstra(5);

    }


   
}
