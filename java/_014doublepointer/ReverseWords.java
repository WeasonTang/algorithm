package _014doublepointer;

/**
 * #151. 反转字符串中的单词
 * 
给你一个字符串 s ，请你反转字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */

public class ReverseWords {

   

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1));

        String s2 = "  hello world  ";
        System.out.println(reverseWords(s2));

        String s3 = "a good   example";
        System.out.println(reverseWords(s3));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            if (split[i] != "") {
                res.append(split[i] + " ");
            }
        }
        res.append(split[0]);
        return res.toString();
    }
}
