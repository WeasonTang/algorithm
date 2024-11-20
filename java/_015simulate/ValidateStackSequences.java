package _015simulate;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * #946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop
 * 操作序列的结果时，返回 true；否则，返回 false 。
 */

public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed1 = { 1, 2, 3, 4, 5 }, popped1 = { 4, 5, 3, 2, 1 };
        System.out.println(validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = { 1, 2, 3, 4, 5 }, popped2 = { 4, 3, 5, 1, 2 };
        System.out.println(validateStackSequences(pushed2, popped2)); // false

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
