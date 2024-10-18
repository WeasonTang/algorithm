package _013hashtable;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * #387. 字符串中的第一个唯一字符
 * 
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * 
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * 
 * 输入: s = "aabb"
 * 输出: -1
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(firstUniqChar(s1)); // 0
        System.out.println(firstUniqChar(s2)); // 2
        System.out.println(firstUniqChar(s3)); // -1

    }

    public static int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
