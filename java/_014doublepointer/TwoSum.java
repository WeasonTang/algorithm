package _014doublepointer;

import java.util.Arrays;

/**
 * #167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target
 * 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <=
 * numbers.length 。
 * 
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));; // [1, 2]
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int residue = target - numbers[i];
            res[0] = i + 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (residue == numbers[j]) {
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return null;
    }

}
