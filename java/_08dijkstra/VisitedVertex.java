package _08dijkstra;

import java.util.Arrays;

public class VisitedVertex {
    // 记录各个顶点是否访问过 1 true 0 false
    public int[] already_arr;

    // 前驱：前一个顶点 在顶点集的index 会动态更新
    public int[] pre_visited;

    // 记录出发顶点到其他所有顶点的距离 会动态更新
    public int[] dis;

    /**
     * 
     * @param length 顶点个数
     * @param index  出发顶点的index
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        pre_visited = new int[length];
        Arrays.fill(pre_visited, -1);
        already_arr[index] = 1;
        dis = new int[length];
        Arrays.fill(dis, 65535);
        dis[index] = 0;
    }

    // 判断index顶点是否被访问过
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    // 更新dis
    public void updateDis(int index, int distance) {
        dis[index] = distance;
    }

    // 把index顶点的前驱更新为pre
    public void updatePre(int index, int pre) {
        pre_visited[index] = pre;
    }

    // 返回出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }

    // 返回新的访问顶点
    public int nextVertex() {
        int min = 65535;
        int index = 0;

        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    // 展示结果
    public void show(char[] vertex, int index) {
        System.out.println("already_arr ----" + Arrays.toString(already_arr));
        System.out.println("pre_visited ----" + Arrays.toString(pre_visited));
        System.out.println("dis ------------" + Arrays.toString(dis));

        for (int i = 0; i < vertex.length; i++) {
            String suffix = "->" + vertex[i];
            // 获取前驱结点下标
            int pre = pre_visited[i];
            while (pre >= 0 && pre != index) {
                suffix = "->" + vertex[pre] + suffix;
                pre = pre_visited[pre];
            }
            String path = vertex[index] + suffix;
            String res = path + "(" + dis[i] + ")";
            System.out.println(res);
        }
    }

}
