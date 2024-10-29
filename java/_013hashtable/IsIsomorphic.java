package _013hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * #205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        System.out.println(isIsomorphic(s1, t1)); // true
        System.out.println(isIsomorphic(s2, t2)); // false
        System.out.println(isIsomorphic(s3, t3)); // true
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, List<Integer>> sMap = new HashMap<>();
        Map<Character, List<Integer>> tMap = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            if (sMap.get(sCharArray[i]) == null) {
                List<Integer> sList = new ArrayList<>();
                sList.add(i);
                sMap.put(sCharArray[i], sList);
            } else {
                sMap.get(sCharArray[i]).add(i);
            }

            if (tMap.get(tCharArray[i]) == null) {
                List<Integer> tList = new ArrayList<>();
                tList.add(i);
                tMap.put(tCharArray[i], tList);
            } else {
                tMap.get(tCharArray[i]).add(i);
            }
        }

        if (sMap.keySet().size() != tMap.keySet().size()) {
            return false;
        }

    
        for (int i = 0; i < sCharArray.length; i++) {
            
            if (!sMap.get(sCharArray[i]).equals(tMap.get(tCharArray[i]))) {
                return false;
            }
        }

        return true;
    }
}
