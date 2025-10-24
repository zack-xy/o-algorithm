package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode2487 {
    /**
     *
     * [2487. 从链表中移除节点](https://leetcode.cn/problems/remove-nodes-from-linked-list/description/?envType=problem-list-v2&envId=linked-list)
     *
      */
    // 我的解法：使用递归，删除一个节点之后，将链表递归回去，再删一遍
    // 通过了基础测试用例，后续的时间超过限制（最差的情况每次都要循环一遍链表，那就是n!的时间复杂度，不知道算的对不对）
    public ListNode removeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preCur = dummyHead;
        ListNode cur = dummyHead.next;
        while (cur != null && cur.next != null) {
            if (cur.val >= cur.next.val) {
                cur = cur.next;
                preCur = preCur.next;
            } else {
                preCur.next = cur.next;
                return removeNodes(dummyHead.next);
            }
        }
        return dummyHead.next;
    }

    // 官方题解一：递归
    // 怎么理解这个递归呢，题目里节点的删除，对这个删除的节点来说，对右侧是没有影响的
    // 所以这个递归就是不断先处理右侧的链表

    /**
     * 我有个疑问🙋：就是删除链表节点是有可能删除头节点的，这里为什么不需要虚拟头节点呢
     *  我的递归因为考虑到会删除头节点，所以增加了虚拟头节点
     * [5,2,13,3,8]比如这个链表，5是怎么删除的？
     *
     * 答：这个递归比较的是head和head.next，如果head.val < head.next.val就返回head.next
     * 所以本身head中确实没有删除头节点，但因为返回的是head.next，返回的结果“看起来”是删除了
     * (看下面的测试代码)
     *
     */
    public static ListNode removeNodes1(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes1(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }

    // 官方题解二：栈
    // 跟递归是一样的，使用栈模拟递归
    public static ListNode removeNodes2(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        for (; head != null; head = head.next) {
            stack.push(head);
        }
        for (; !stack.isEmpty(); stack.pop()) {
            if (head == null || stack.peek().val >= head.val) {
                stack.peek().next = head;
                head = stack.peek();
            }
        }
        return head;
    }


    // 官方题解三：反转链表
    // 但链表从左到右更高效，所以反转链表，反问题处理
    public ListNode removeNodes3(ListNode head) {
        head = reverse(head);
        for (ListNode p = head;p.next!=null;) {
            if (p.val > p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode linkedList = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        /**

        ListNode result = removeNodes1(linkedList);
        System.out.println(linkedList.val); // 看原linkedList的头节点还是5
        System.out.println(result.val);  // 但是返回的是head.next，所以看起来是删除了

         **/
        ListNode result = removeNodes2(linkedList);
        System.out.println(linkedList.val);
        System.out.println(result.val);

    }
}
