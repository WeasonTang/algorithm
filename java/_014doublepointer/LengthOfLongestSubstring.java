package _014doublepointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * #3. 无重复字符的最长子串
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); //"abc" 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); //"b" 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); //"wke" 3

        String s4 = " ";
        System.out.println(lengthOfLongestSubstring(s4)); //" " 1

        String s5 = "";
        System.out.println(lengthOfLongestSubstring(s5)); //"" 0

        String s6 = "c";
        System.out.println(lengthOfLongestSubstring(s6)); // "c" 1

        String s7 = "au";
        System.out.println(lengthOfLongestSubstring(s7)); // "au" 2

        String s8 ="dvdf";
        System.out.println(lengthOfLongestSubstring(s8)); // "vdf" 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        String sub = "";
        Set<Character> has = new HashSet<>();
        int rk = 0;
        for (int i = 0; i < length; i++) {           
            while (rk < length && has.add(s.charAt(rk))) {
                rk++;
            }
            
            if (sub.length() < rk - i) {
                sub = s.substring(i, rk);
            }
            has.remove(s.charAt(i));
        }
        System.out.println("最长子串：" + sub);
        return sub.length();
    }
}
