package _11linkedlist;

/*
 #86. 分隔链表
 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 你应当 保留 两个分区中每个节点的初始相对位置。

    输入：head = [1,4,3,2,5,2], x = 3
    输出：[1,2,2,4,3,5]

    输入：head = [2,1], x = 2
    输出：[1,2]

*/
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.addNode(new ListNode(1));
        // head.addNode(new ListNode(2));
        // head.addNode(new ListNode(5));
        // head.addNode(new ListNode(2));

        head.show();
        partition(head, 2).show();
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode bigListNode = new ListNode();
        ListNode bigListNodeLast = bigListNode;

        ListNode resList = new ListNode();
        resList.next = head;

        ListNode temp = resList;
        while (temp.next != null) {
            if (temp.next.val >= x) {
                bigListNodeLast.next = temp.next;
                bigListNodeLast = temp.next;
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        bigListNodeLast.next = null;
        temp.next = bigListNode.next;

        return resList.next;
    }
}
