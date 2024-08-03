package _11linkedlist;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
随机链表的复制

 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。

 */

public class CopyRandomList {
    public static void main(String[] args) {
        Node head = new Node(7, null);
        Node node1 = new Node(13, head);
        Node node2 = new Node(11);
        Node node3 = new Node(10, node2);
        Node node4 = new Node(1, head);
        node2.random = node4;
        head.addNode(node1);
        head.addNode(node2);
        head.addNode(node3);
        head.addNode(node4);
        head.show();

        Node copyNode = copyRandomList2(head);
        copyNode.show();

    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node copyHead = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node tempNew = copyHead;
        map.put(temp, tempNew);
        while (temp.next != null) {
            temp = temp.next;
            tempNew.next = new Node(temp.val);
            tempNew = tempNew.next;
            map.put(temp, tempNew);
        }
       
        for (Entry<Node,Node> entry : map.entrySet()) {
            Node random = entry.getKey().random;
            if (random != null) {
                entry.getValue().random = map.get(random);
            } else {
                entry.getValue().random = null;
            }
        }

        return copyHead;
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node copyNode = new Node(head.val);
        if (head.next == null) {
            if (head.random == head) {
                copyNode.random = copyNode;
            }
            return copyNode;
        }
        int length = 1;
        Node temp = head;
        Node tempNew = copyNode;
        while (temp.next != null) {
            length++;
            temp = temp.next;
            tempNew.next = new Node(temp.val);
            tempNew = tempNew.next;
        }
        Node[] nodeArr = new Node[length];
        Node[] nodeArrNew = new Node[length];
        temp = head;
        tempNew = copyNode;
        int index = 0;
        while (temp != null) {
            nodeArr[index] = temp;
            nodeArrNew[index] = tempNew;
            temp = temp.next;
            tempNew = tempNew.next;
            index++;
        }

        int j;
        for (int i = 0; i < length; i++) {
            Node random = nodeArr[i].random;
            j = -1;
            if (random != null) {
                for (j = 0; j < nodeArr.length; j++) {
                    if (nodeArr[j] == random) {
                        break;
                    }
                }
            }

            nodeArrNew[i].random = (j >= 0 && j < length ? nodeArrNew[j] : null);
        }
        return copyNode;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node random) {
        this.val = val;
        this.next = null;
        this.random = random;
    }

    public void addNode(Node node) {
        Node temp = this;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show() {
        Node temp = this;
        // 获取链表长度
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        Node[] nodeArr = new Node[length];
        temp = this;
        int index = 0;
        while (temp != null) {
            nodeArr[index] = temp;
            temp = temp.next;
            index++;
        }
        System.out.print("[");
        for (int i = 0; i < nodeArr.length; i++) {
            Node random = nodeArr[i].random;

            int j = 0;
            for (; j < nodeArr.length; j++) {
                if (nodeArr[j] == random) {
                    break;
                }
            }

            System.out.print("[" + nodeArr[i].val + "," + (j < length ? j : null) + "],");
        }

        System.out.println("]");
    }

}