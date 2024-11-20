package _015simulate;

import java.util.ArrayList;
import java.util.List;

/**
 * #54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spiralOrder(matrix1)); // [1,2,3,6,9,8,7,4,5]

        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix2)); // [1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        System.out.println(spiralOrder(matrix3)); //[1,2,3,4,8,12,16,20,24,23,22,21,17,13,9,5,6,7,11,15,19,18,14,10]

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] path = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        isPath(res, path, matrix, i, j);
        while (res.size() < matrix.length * matrix[0].length) {
            while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length - 1 && isPath(res, path, matrix, i, j + 1)) {
                j++;
            }
            while (i >= 0 && i < matrix.length - 1 && j >= 0 && j < matrix[0].length && isPath(res, path, matrix, i + 1, j)) {
                i++;
            }
            while (i >= 0 && i < matrix.length && j >= 1 && j < matrix[0].length && isPath(res, path, matrix, i, j - 1)) {
                j--;
            }
            while (i >= 1 && i < matrix.length && j >= 0 && j < matrix[0].length && isPath(res, path, matrix, i - 1, j)) {
                i--;
            }
        }
        return res;
    }

    public static boolean isPath(List<Integer> res, boolean[][] path, int[][] matrix, int i, int j) {
        if (!path[i][j]) {
            res.add(matrix[i][j]);
            path[i][j] = true;
            return true;
        }
        return false;
    }
}
