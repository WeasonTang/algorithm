package _11linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addNode(ListNode node) {
        ListNode temp = this;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show() {
        
        ListNode temp = this;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
