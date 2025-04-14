package algorithm.链表常见题.合并2个有序链表;

import dataStructure.链表.ListNode;

public class mergeTwoLists {

    // 解法一：代码一
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;
        while (list1 != null || list2 != null) {
            // 情况1: 都不为空的情况
            if(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    newHead.next = list1;
                    list1 = list1.next;
                } else if(list1.val > list2.val) {
                    newHead.next = list2;
                    list2 = list2.next;
                } else {
                    newHead.next = list2;
                    list2 = list2.next;
                    newHead = newHead.next;
                    newHead.next = list1;
                    list1 = list1.next;
                }
                newHead = newHead.next;
            } else if(list1 != null && list2 == null) {
                newHead.next = list1;
                list1 = list1.next;
                newHead = newHead.next;
            } else if(list1 == null && list2 != null) {
                newHead.next = list2;
                list2 = list2.next;
                newHead = newHead.next;
            }
        }
        return res.next;
    }

    // 解法一：精简代码优化一
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else if(list1.val > list2.val) {
                newHead.next = list2;
                list2 = list2.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
                newHead = newHead.next;
                newHead.next = list1;
                list1 = list1.next;
            }
            newHead = newHead.next;
        }
        // 下面的两个while最多只有一个会执行
        while (list1 != null) {
            newHead.next = list1;
            list1 = list1.next;
            newHead = newHead.next;
        }
        while (list2 != null) {
            newHead.next = list2;
            list2 = list2.next;
            newHead = newHead.next;
        }

        return res.next;
    }

    // 解法一：精简代码优化二
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 最多还有一个链表未被合并完，直接接上就行了
        prev.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}
