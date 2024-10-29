package _014doublepointer;

/**
 * 
 * #392. 判断子序列
 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class IsSubsequence {


    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";

        String s2 = "axc";
        String t2 = "ahbgdc";

        String s3 = "";
        String t3 = "";

        String s4 = "aaaaaa";
        String t4 = "bbaaaa";

        String s5 = "b";
        String t5 = "c";

        System.out.println(isSubsequence(s1, t1)); //true
        System.out.println(isSubsequence(s2, t2)); //false
        System.out.println(isSubsequence(s3, t3)); //true
        System.out.println(isSubsequence(s4, t4)); //false
        System.out.println(isSubsequence(s5, t5)); //false

    }


    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char c = s.charAt(i);
            for (; j < t.length(); j++) {
                if (c == t.charAt(j)) {
                    i++;
                    j++;
                    break;
                }
            }    
        }

        if (i == s.length()) {
            return true;
        }
        return false;
    }
}
