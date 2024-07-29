package _07kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class BusStation {
    // 边的数量
    private int edgeNum;
    // 顶点数组
    private char[] vertexs;
    // 邻接矩阵
    private int[][] matrix;

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = {
                        /* A *//* B *//* C *//* D *//* E *//* F *//* G */
                /* A */ { 0, 12, INF, INF, INF, 16, 14 },
                /* B */ { 12, 0, 10, INF, INF, 7, INF },
                /* C */ { INF, 10, 0, 3, 5, 6, INF },
                /* D */ { INF, INF, 3, 0, 4, INF, INF },
                /* E */ { INF, INF, 5, 4, 0, 2, 8 },
                /* F */ { 16, 7, 6, INF, 2, 0, 9 },
                /* G */ { 14, INF, INF, INF, 8, 9, 0 }
        };
        BusStation busStation = new BusStation(vertexs, matrix);
        // System.out.println(System.identityHashCode(vertexs));
        // System.out.println(System.identityHashCode(busStation.vertexs));
        busStation.print();
        // System.out.println(Arrays.toString(edges));
        EdgeData[] res = busStation.kruskal();
        System.out.println(Arrays.toString(res));
    }

    public EdgeData[] kruskal() {
        // 最后结果数组的索引
        int index = 0;
        // 保存 当前最小生成树 中每个顶点的终点 
        int[] ends = new int[edgeNum];

        // 创建结果数组
        EdgeData[] res = new EdgeData[edgeNum - 1];

        // 获取所有边集合
        EdgeData[] edges = getEdges();
        System.out.println(Arrays.toString(edges));
        System.out.println("-----------");

        // 遍历edges 数组, 
        // 判断边是否形成回路  添加到最小生成树中 
        for (int i = 0; i < edgeNum; i++) {
            // 获取第i 条边的一个顶点
            int onePoint = getVertexIndex(edges[i].onePoint);
            // 获取第i 条边的另一个顶点
            int anotherpoint = getVertexIndex(edges[i].anotherPoint);

            // 获取onePoint 在当前最小生成树的终点
            int m = getEnd(ends, onePoint);
            // 获取anotherPoint 的终点
            int n = getEnd(ends, anotherpoint);
            // 是否构成回路
            if (m != n) { 
                // 把m 在当前最小生成树的终点设置成 n 
                ends[m] = n;  
                res[index++] = edges[i];
            }
        }
        return res;
    }

    // 构造器
    public BusStation(char[] vertexs, int[][] matrix) {
        // 初始化顶点数和边的个数
        int vlen = vertexs.length;

        // 初始化顶点
        // 方法一 不能隔离数据
        // this.vertexs = vertexs;
        // 方法二和三 可以
        // this.vertexs = new char[vlen];
        // for (int i = 0; i < vlen; i++) {
        // this.vertexs[i] = vertexs[i];
        // }
        this.vertexs = vertexs.clone();

        // 初始化边
        // this.matrix = new int[vlen][vlen];
        // for (int i = 0; i < vlen; i++) {
        // for (int j = 0; j < vlen; j++) {
        // this.matrix[i][j] = matrix[i][j];
        // }
        // }
        this.matrix = matrix.clone();

        // 统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    // 打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为: ");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%10d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // 对边按权值进行排序
    private void sortEdges(EdgeData[] edges) {
        EdgeData temp;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 -i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }   
            }
        }
    }

    // 获取顶点对应下标
    private int getVertexIndex(char vertex) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertex == vertexs[i]) {
                return i;
            }
        }
        return -1;
    }

    // 获取边集
    private EdgeData[] getEdges() {
        int index = 0;
        EdgeData[] edges = new EdgeData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EdgeData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        // 排序并返回
        return Arrays.stream(edges).sorted(Comparator.comparing(EdgeData::getWeight)).toArray(EdgeData[]::new);
    }

    // 获取下标为i 的顶点的终点
    private int getEnd(int[] ends, int i) {
        // 等于0 代表 还没有...过  终点下标就是自己
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}
