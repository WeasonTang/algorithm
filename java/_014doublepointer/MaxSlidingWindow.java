package _014doublepointer;

import java.util.Arrays;

/**
 * #239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k1 = 3;
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));

        int[] nums2 = {1, -1};
        int k2 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {           
            if (maxIndex >= i) {
                if (max <= nums[i + k - 1]) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
            } else {
                max = nums[i];
                maxIndex = i;
                for (int j = 1; j < k; j++) {
                    if (max <= nums[i + j]) {
                        max = nums[i + j];
                        maxIndex = i + j;
                    }
                }
            }
            res[i] = max;  
        }
        return res;
    }
}
