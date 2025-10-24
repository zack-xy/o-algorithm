package algorithm.链表常见题.合并链表;

import dataStructure.链表.ListNode;

/**
 * [1669. 合并两个链表](https://leetcode.cn/problems/merge-in-between-linked-lists/description/)
 * 
 * ##### 解法一：
 * 
    1、需要找到链表list1的a节点的上一个节点（从这里断开链接链表list2
    2、需要找到链表list1的b节点的下一个节点（从这里链接list2的尾部
    所以需要3个变量，1个指向a节点的上一个节点，1个指向b节点的下一个节点，1个指向list2的尾部
    变量1.next = list2的头节点
    list2的尾部.next = 变量2
    另外需要i，j两个变量，用来计数到a和b位置

 * 
 * 
 */

public class Leetcode1669 {
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

    // 跟上面一样，优化了一个变量
    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre1 = list1, post1 = list1, post2 = list2;
        int i = 0;
        while (i < b) {
            if(i < a - 1) {
                pre1 = pre1.next;
            }
            post1 = post1.next;
            i++;
        }
        post1 = post1.next;
        while (post2.next != null) {
            post2 = post2.next;
        }
        pre1.next = list2;
        post2.next = post1;
        return list1;
    }
}
