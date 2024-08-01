package _08dijkstra;

import java.util.Arrays;

public class Graph {
    private char[] vertex; // 顶点集
    private int[][] matrix; // 邻接矩阵 边集

    // 已经访问的顶点的集合
    private VisitedVertex vv;

    // 构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex.clone();
        this.matrix = matrix.clone();
    }

    // 显示图
    public void showGraph() {
        Arrays.stream(matrix).forEach(link -> System.out.println(Arrays.toString(link)));
    }

    // dijkstra算法
    // index 起始位置(出发点)
    public void dijkstra(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);
        int next;
        for (int i = 1; i < vertex.length; i++) {
            next = vv.nextVertex();
            update(next);
        }
        vv.show(vertex, index);
    }

    

    // 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index) {
        int distance;
        for (int j = 0; j < matrix[index].length; j++) {
            // 出发顶点到j的距离 = 出发顶点到index + index到j
            distance = vv.getDis(index) + matrix[index][j];
            if (!vv.in(j) && distance < vv.getDis(j)) {
                // 更换j的前驱为undex
                vv.updatePre(j, index);
                vv.updateDis(j, distance);
            }
        }
        
    }

}
