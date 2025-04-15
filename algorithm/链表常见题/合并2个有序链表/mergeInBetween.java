package algorithm.链表常见题.合并2个有序链表;

import dataStructure.链表.ListNode;

public class mergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre1 = list1, post1 = list1, post2 = list2;
        int i = 0, j = 0;
        while (pre1 != null && post1 != null && j < b) {
            if (i != a - 1) {
                pre1 = pre1.next;
                i++;
            }
            if(j != b) {
                post1 = post1.next;
                j++;
            }
        }
        post1 = post1.next;
        // 寻找list2的尾节点
        while (post2.next != null) {
            post2 = post2.next;
        }
        pre1.next = list2;
        post2.next = post1;
        return list1;
    }
}
