package _12stack_queue;

import java.util.LinkedList;

/**
 * 
 * #155 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 实现 MinStack 类:
 * 
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 
 * 
 * 示例 1:
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); --> 返回 -3.
 * minStack.pop();
 * minStack.top(); --> 返回 0.
 * minStack.getMin(); --> 返回 -2.
 * 
 * 
 * 提示：
 * 
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 *
 * 
 */

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); // --> 返回 0.
        System.out.println(minStack.getMin()); // --> 返回 -2.
    }

    private LinkedList<Integer> stack;
    private int minVal;
    private int minNumCount = 0;

    public MinStack() {
        this.stack = new LinkedList<Integer>();

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minVal = val;
        } else {
            if (val < minVal) {
                minVal = val;
                minNumCount = 1;
            } else if (val == minVal) {
                minNumCount++; 
            }
        }
        this.stack.push(val);
    }

    public void pop() {
        int popVal = stack.pop();
        if (popVal == minVal) {
            if (minNumCount > 1) {
                minNumCount--;
            } else if(!stack.isEmpty()) {
                minVal = stack.get(0);
                for (int i = 1; i < stack.size(); i++) {
                    if (stack.get(i) < minVal) {
                        minVal = stack.get(i);
                    }
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
    }

}
