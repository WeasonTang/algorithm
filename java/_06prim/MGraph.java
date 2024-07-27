package _06prim;

// 定义图
public class MGraph {
    int vertexNum; // 图的顶点个数
    char[] data; // 存放顶点数据 顶点集
    int[][] weight; // 存放边，就是邻接矩阵  边集

    public MGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        data = new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
    }
}
