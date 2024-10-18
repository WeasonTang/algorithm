package _12stack_queue;

import java.util.Stack;

/*
#20 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 ：

输入：s = "()"
输出：true

输入：s = "()[]{}"
输出：true

输入：s = "(]"
输出：false
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String input = "(dfsfs";
        System.out.println(isValid(input));

    }
    
    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        char front;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' || arr[i] == ']' || arr[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                front = stack.pop();
                switch (front) {
                    case '(':
                        if (arr[i] != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (arr[i] != ']') {
                            return false;
                        }
                        break;
                        case '{':
                        if (arr[i] != '}') {
                            return false;
                        }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
