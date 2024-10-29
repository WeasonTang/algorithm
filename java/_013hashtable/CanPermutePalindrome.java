package _013hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * # 266回文排序
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 */

public class CanPermutePalindrome {

    public static void main(String[] args) {
        String s1 = "code";
        String s2 = "aab";
        String s3 = "carerac";

        System.out.println(canPermutePalindrome(s1)); // false
        System.out.println(canPermutePalindrome(s2)); // true
        System.out.println(canPermutePalindrome(s3)); // true

    }

    public static boolean canPermutePalindrome(String s) {
        int oddNum = 0;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Entry<Character,Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() % 2 == 1) {
                oddNum++;
            }
        }
        
        return oddNum <= 1;
    }
}
