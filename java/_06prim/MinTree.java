package _06prim;

import java.util.Arrays;

// 创建最小生成树
public class MinTree {

    // 创建图的邻接矩阵
    /**
     * 
     * @param graph     图对象
     * @param vertexNum 图对应的顶点个数
     * @param data      图的各个顶点的值
     * @param weight    图的邻接矩阵
     */
    public void createGraph(MGraph graph, int vertexNum,
            char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < vertexNum; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < vertexNum; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        Arrays.stream(graph.weight).forEach(adjacency -> System.out.println(Arrays.toString(adjacency)));
    }
}
