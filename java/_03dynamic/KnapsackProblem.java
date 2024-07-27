package _03dynamic;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品重量
        int[] w = { 0, 1, 4, 3 };
        // 物品价值
        int[] val = { 0, 1500, 3000, 2000 };
        // 背包容量
        int m = 4;
        // 物品的个数
        int n = val.length - 1;

        // path记录背包放置信息 
        String[][] path = new String[n + 1][m + 1];
        String[] name = {"", "吉他", "音响", "电脑"};

        // 创建二维数组
        // v[i][j] 表示在前i的物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        // 初始化第一行和第一列
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0; // 将第一行设置为0
            path[0][i] = "";
        }
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; // 将第一列设置为0
            path[i][0] = "";
        }

        // 根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                // 公式
                if (w[i] > j) {
                    v[i][j] = v[i - 1][j];
                    path[i][j] = path[i -1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], val[i] + v[i - 1][j - w[i]]);
                    // 为了记录商品存放信息
                    if (v[i - 1][j] < val[i] + v[i - 1][j - w[i]]) {
                        v[i][j] = val[i] + v[i - 1][j - w[i]];
                        // 把当前情况记录到
                        if (path[i - 1][j - w[i]] != "") {
                            path[i][j] = name[i] + "+" + path[i - 1][j - w[i]];
                        } else {
                            path[i][j] = name[i];
                        }                                       
                    } else {
                        v[i][j] = v[i - 1][j];
                        path[i][j] = path[i -1][j];
                    }
                }
            }
        }

        Arrays.stream(v).forEach(t -> System.out.println(Arrays.toString(t)));
        System.out.println("path-----: ");
        Arrays.stream(path).forEach(t -> System.out.println(Arrays.toString(t)));
    }

}
