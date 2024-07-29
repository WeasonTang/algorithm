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

    // prim算法， 得到最小生成树
    public  void prim(MGraph graph, int vertex) {
        // 标记节点是否被访问过 由于java int默认值是0 可以不用初始化
        int visited[] = new int[graph.vertexNum];

        // 把当前节点标记为已访问
        visited[vertex] = 1;
        // h1和h2 记录两个顶点下标
        int h1 = -1;
        int h2 = -1;
        // 将minWeight 初始化成一个较大数 后面遍历过程中会被替换
        int minWeight = 10000;
        // 定义总权值
        int totalWeight = 0;
        for (int k = 1; k < graph.vertexNum; k++) { // 生成vertexNum - 1 条边
            // i 访问过的节点 j 未访问过的节点
            for (int i = 0; i < graph.vertexNum; i++) {
                for (int j = 0; j < graph.vertexNum; j++) {
                    if (visited[i] == 1 && visited[j] == 0
                            && graph.weight[i][j] < minWeight) {
                        // 替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到本轮最小边 h1h2
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值: " + minWeight);
            visited[h2] = 1;
            totalWeight += minWeight;
            // 重置 开始下一轮
            minWeight = 10000;
        }
        System.out.println("总权值: " + totalWeight);

    }
}
