package _06prim;

public class PrimAlgorithm {
    public static void main(String[] args) {
        // 测试
        char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int vertexNum = data.length;
        // 邻接矩阵
        int[][] weight = new int[][] {
                { 10000, 5, 7, 10000, 10000, 10000, 2 },
                { 5, 10000, 10000, 9, 10000, 10000, 3 },
                { 7, 10000, 10000, 10000, 8, 10000, 10000 },
                { 10000, 9, 10000, 10000, 10000, 4, 10000 },
                { 10000, 10000, 8, 10000, 10000, 5, 4 },
                { 10000, 10000, 10000, 4, 5, 10000, 6 },
                { 2, 3, 10000, 10000, 4, 6, 10000 }
        };
        MGraph mGraph = new MGraph(vertexNum);

        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, vertexNum, data, weight);
        minTree.showGraph(mGraph);

    }

}
