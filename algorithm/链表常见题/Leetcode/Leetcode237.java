package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

public class Leetcode237 {
    /**
     *
     * [237. 删除链表中的节点](https://leetcode.cn/problems/delete-node-in-a-linked-list/?envType=problem-list-v2&envId=linked-list)
     *
     * 老实说，根本没读懂题目
     * 我好像智商受到暴击
     */

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

