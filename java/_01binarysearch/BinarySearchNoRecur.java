package _01binarysearch;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        // test
        int[] arr = { 1, 3, 8, 10, 11, 67, 100 };
        System.out.println(binarySearch(arr, 100));

    }

    // 二分查找的非递归实现
    /**
     * 
     * @param arr    待查找的数组arr
     * @param target 需要查找的数
     * @return 对应下标 -1 没找到
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; // 向左边查找
            } else { // 向右查找
                left = mid + 1;
            }

        }
        return -1;
    }
}
