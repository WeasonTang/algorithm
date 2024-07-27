package _04kmp;

import java.util.Arrays;

public class StringMatch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        // 暴力匹配 效率低
        // System.out.println(violenceMatch(str1, str2));

        
        System.out.println(kmpMatch(str1, str2));


    }

    // kmp
    public static int kmpMatch(String str1, String str2) {
        // 获取到部分匹配值表
        int[] next = kmpNext(str2);
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // kmp算法核心 处理str1.charAt(i) ！= str2.charAt(j)
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1]; 
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                return i - j + 1;
            }

        }

        return -1;
    }

    // 获取到一个字符串字串的部分匹配值表
    private static int[] kmpNext(String dest) {

        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

    // 暴力匹配 效率低
    public static int violenceMatch(String str1, String str2) {
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        int len1 = charArr1.length;
        int len2 = charArr2.length;

        // i指向charArr1
        int i = 0;
        // j指向charArr2
        int j = 0;
        while (i < len1 && j < len2) {
            if (charArr1[i] == charArr2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == len2) {
            return i - j;
        }

        return -1;
    }
}
