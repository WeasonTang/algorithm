package _014doublepointer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * # 15.三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i!= j、i != k 且 j != k
 * ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums1));

        int[] nums2 = { 0, 1, 1 };
        System.out.println(threeSum(nums2));

        int[] nums3 = { 0, 0, 0, 0 };
        System.out.println(threeSum(nums3));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");
        Date dateBefore = new Date();
        String before = simpleDateFormat.format(dateBefore);
        System.out.println("before: " + before);

        threeSum(TestNum.nums);

        Date dateLater = new Date();
        String later = simpleDateFormat.format(dateLater);
        System.out.println("later: " + later);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {                
                    while(j < k && nums[i] == nums[++j]);                 
                } else if (sum > 0) {
                    while(j < k && nums[k] == nums[--k]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(j < k && nums[i] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i])
                        ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j])
                        ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
