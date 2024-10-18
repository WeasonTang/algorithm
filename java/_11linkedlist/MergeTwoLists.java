package _11linkedlist;

/* 
    #21 合并两个序列
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4] 
*/

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        list1.addNode(new ListNode(2));
        list1.addNode(new ListNode(4));
        list2.addNode(new ListNode(3));
        list2.addNode(new ListNode(4));
        list1.show();
        list2.show();

        mergeTwoLists(list1, list2).show();
        

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int tempVal1;
        int tempVal2;
        if (list1 != null) {
            tempVal1 = list1.val;
        } else {
            if (list2 != null) {
                return list2;
            } else {
                return null;
            }
        }
 
        if (list2 != null) {          
            tempVal2 = list2.val;
        } else {
            return list1;
        }

        ListNode resList;
        int flag;
        if (tempVal1 <= tempVal2) {
            resList = list1;
            flag = 1;
            if (list1.next != null) {
                list1 = list1.next;
                tempVal1 = list1.val;
            } else {
                list1.next = list2;
                return resList;
            }
        } else {
            resList = list2;
            flag = 2;
            if (list2.next != null) {
                list2 = list2.next;
                tempVal2 = list2.val;
            } else {
                list2.next = list1;
                return resList;
            }
        }
        ListNode resListLast = resList;

        while (list1 != null || list2 != null) {
            // flag1
            if (tempVal1 <= tempVal2) {
                if (list1.next != null) {
                    if (flag == 1) {
                        list1 = list1.next;
                        tempVal1 = list1.val;
                        resListLast = resListLast.next;
                    } else {
                        flag = 1;
                        resListLast.next = list1;
                        resListLast = list1;
                        
                        list1 = list1.next;
                        tempVal1 = list1.val;
                    }
                } else {
                    resListLast.next = list1;
                    list1.next = list2;
                    return resList;
                }
            } else { // flag2
                if (list2.next != null) {
                    if (flag == 2) {
                        list2 = list2.next;
                        tempVal2 = list2.val;
                        resListLast = resListLast.next;
                    } else {
                        flag = 2;
                        resListLast.next = list2;
                        resListLast = list2;
                        
                        list2 = list2.next;
                        tempVal2 = list2.val;
                    }
                } else {
                    resListLast.next = list2;
                    list2.next = list1;
                    return resList;
                }
            }

        }
        return resList;
    }
}

