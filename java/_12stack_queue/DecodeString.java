package _12stack_queue;

import java.util.Stack;

/**
 * 
 * # 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 
 * 
 * 提示：
 * 
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class DecodeString {

    private static char[] charArray2;
    private static String[] split;

    public static void main(String[] args) {
        String test1 = "3[a]2[bc]"; // "aaabcbc"
        String test2 = "3[a2[c]]"; // "accaccacc"
        String test3 = "2[abc]3[cd]ef"; // "abcabccdcdcdef"
        String test4 = "abc3[cd]xyz"; // "abccdcdcdxyz"

        System.out.println("test1: " + decodeString(test1));
        System.out.println("test2: " + decodeString(test2));
        System.out.println("test3: " + decodeString(test3));
        System.out.println("test4: " + decodeString(test4));
    }

    public static String decodeString(String s) {
        int num = 1;
        String res = "";
        String subString = "";
        String numString = "";
        String temp = "";

        String regexNum = "[0-9]";

        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if ("]".equals(split[i])) {
                temp = stack.pop();
                while (!"[".equals(temp)) {
                    subString = temp + subString;
                    temp = stack.pop();
                }
                temp = stack.pop();
                numString = temp;

                while (!stack.isEmpty() && stack.peek().matches(regexNum)) {
                    temp = stack.pop();
                    numString = temp + numString;
                }
                
                num = Integer.parseInt(numString);
                temp = "";
                for (int j = 1; j <= num; j++) {
                    temp = temp + subString;
                }
                stack.push(temp);
                subString = "";
            } else {
                stack.push(split[i]);
            }
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();
            res = temp + res;
        }

        return res;
    }

    

}
