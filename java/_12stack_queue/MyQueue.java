package _12stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * #232 用栈实现队列
 * 
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 
 * 实现 MyQueue 类：
 * 
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 
 */

public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    private Stack<Integer> forward;
    private Stack<Integer> reverse;

    public MyQueue() {
        this.forward = new Stack<Integer>();
        this.reverse = new Stack<Integer>();
    }

    public void push(int x) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(x);
    }

    public int pop() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        return reverse.pop();
    }

    public int peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        return reverse.peek();
    }

    public boolean empty() {
        return forward.isEmpty() && reverse.isEmpty();
    }
}
