package _013hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * #409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的
 * 回文串的长度。
 * 
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 提示:
 * 
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";

        //可以构造的最长的回文串是"dccaccd", 它的长度是 7。
        System.out.println(longestPalindrome(s1)); 

        //可以构造的最长回文串是"a"，它的长度是 1。
        System.out.println(longestPalindrome(s2));
    }

    public static int longestPalindrome(String s) {

        int count = 0;

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Entry<Character,Integer> entry : map.entrySet()) {
            count = entry.getValue() / 2 + count;
        }

        return Math.min(count * 2 + 1, s.length());
    }
}
