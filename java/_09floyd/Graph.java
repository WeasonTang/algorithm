package _09floyd;

import java.util.Arrays;

public class Graph {
    private char[] vertex; // 顶点集
    private int[][] matrix; // 邻接矩阵 边集

    // 各个 顶点到其他所有顶点的距离 会动态更新
    public int[][] dis;

    // 前驱：前一个顶点 在顶点集的index 会动态更新
    public int[][] pre;

    // 构造器
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix.clone();
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    // 显示 dis 和 pre
    public void show() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                System.out.printf("%s ", vertex[pre[i][j]]);
            }
            System.out.println();
            
        }

        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                System.out.printf("(%s->%s=%d)\t", vertex[i], vertex[j], dis[i][j]);
            }
            System.out.println();
        }
    }

    // floyd
    public void floyd() {
        int len = 0;
        // 中间顶点 遍历
        for (int i = 0; i < dis.length; i++) {
            // 出发顶点
            for (int j = 0; j < dis.length; j++) {
                // 终点
                for (int k = 0; k < dis.length; k++) {
                    // 出发顶点到中间顶点的距离
                    len = dis[j][i] + dis[i][k];
                    if (len < dis[j][k]) {
                        dis[j][k] = len;
                        // ?  为什么不是i
                        // pre[j][k] = i;
                        pre[j][k] = pre[i][k];
                    }
                }
            }
        }
    }

}
