package _014doublepointer;

import java.util.List;

import _11linkedlist.ListNode;

/**
 * #876. 链表的中间结点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5] 输出：[3,4,5]
        ListNode head = new ListNode(1);
        head.addNode(new ListNode(2));
        head.addNode(new ListNode(3));
        head.addNode(new ListNode(4));
        head.addNode(new ListNode(5));
        middleNode(head).show();;

        
        // 输入：head = [1,2,3,4,5,6] 输出：[4,5,6]
        head.addNode(new ListNode(6));
        middleNode(head).show();
    }

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        ListNode half = head;
        int tempCount = 0;
        while (temp.next != null) {
            temp = temp.next;
            tempCount++;
            if (tempCount % 2 == 1) {
                half = half.next;
            }
        }
        return half;
    }
}
