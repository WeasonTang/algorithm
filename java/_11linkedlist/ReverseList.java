package _11linkedlist;

/* 
    #206. 反转链表
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1] 
*/

public class ReverseList {
    public static void main(String[] args) {
        ListNode original = new ListNode(1);
        original.addNode(new ListNode(2));
        original.addNode(new ListNode(3));
        original.addNode(new ListNode(4));
        original.addNode(new ListNode(5));
        original.show();

        ListNode reverse = reverseList(original);
        reverse.show();
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode front = head;
        ListNode mid = front.next;
        ListNode rear = mid.next;
        front.next = null;
        mid.next = front;

        while (rear != null) {
            front = mid;
            mid = rear;
            rear = mid.next;
            mid.next = front;
        }

        return mid;
    }

}
