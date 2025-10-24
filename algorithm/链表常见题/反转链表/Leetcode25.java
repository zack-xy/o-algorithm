package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

public class Leetcode25 {
    /**
     *
     * [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/description/)
     *
     */

    // 解法一：头插法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head;
        int len = 0;  // 计算链表长度
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int n = len / k; // 计算出有几组
        ListNode pre = dummyNode;
        cur = head;
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode next = cur.next;
                cur.next = cur.next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }

    // 解法二：穿针引线法

    /**
     *
     * 需要4个指针
     *
     * pre：反转区间的前1个节点。用来连接反转后的节点
     * start：反转区间开始节点
     * end：反转区间结束节点
     * next：反转区间后面剩余节点的嗲一个，反转后的区间子链表需要重新连接剩下的部分
     *
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 找到要处理的区间的末尾
            for (int i = 0; i < k && end != null; i++) {
                end  = end.next;
            }
            if (end == null) {   // 这里如果区间不足k的话，就不执行了
                break;
            }
            // 将要处理的区间裁剪下来
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 执行反转
            pre.next = reverse(start);
            // 上面pre.next和下面start.next两个指针是为了将反转的区间缝补回去
            start.next = next;
            // 调整指针，为下一组做准备
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 链表反转
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
