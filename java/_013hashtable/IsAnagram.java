package _013hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * # 242. 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词.
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 
 * 提示:
 * 
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * 
 * 
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat"; 
        String t2 = "car";

        System.out.println(isAnagram(s1, t1)); // true
        System.out.println(isAnagram(s2, t2)); // false
    }

    public static boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        if (sCharArray.length != tCharArray.length) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < tCharArray.length; i++) {
            if (sMap.get(sCharArray[i]) == null) {
                sMap.put(sCharArray[i], 1);
            } else {
                sMap.put(sCharArray[i], sMap.get(sCharArray[i]) + 1);
            }

            if (tMap.get(tCharArray[i]) == null) {
                tMap.put(tCharArray[i], 1);
            } else {
                tMap.put(tCharArray[i], tMap.get(tCharArray[i]) + 1);
            }
        }

        for (Entry<Character,Integer> sEntry : sMap.entrySet()) {
            Integer tValue = tMap.get(sEntry.getKey());
            if (tValue == null || !tValue.equals(sEntry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
