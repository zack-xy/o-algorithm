package algorithm.堆常见题;

import dataStructure.链表.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/description/)
 *
 */
public class mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            if (tail.next != null) {
                minHeap.add(tail.next);
            }
        }
        return dummy.next;
    }

}
