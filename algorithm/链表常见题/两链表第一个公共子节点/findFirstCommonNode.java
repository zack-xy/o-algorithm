package algorithm.链表常见题.两链表第一个公共子节点;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import dataStructure.链表.ListNode;

/**
 * 
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/description/
 *
 *  解法一：使用哈希和集合处理
 *
 *  解法二：使用栈解决
 *
 *  解法三：拼接字符串
 *  解释：
 *  A链表：0-1-2-3-4-5
 *  B链表：a-b-4-5
 *  AB拼接：0-1-2-3-4-5-a-b-4-5
 *  BA拼接：a-b-4-5-0-1-2-3-4-5
 *
 *  AB和BA从4开始相同，4就是要找的节点
 *
 *
 *  解法四：差和双指针
 *  两个链表有长度差l，让长的链表先走l，然后再一起走，走到相同的那个节点就是
 *  第一个共同节点
 *
 */

public class findFirstCommonNode {
    // 使用哈希和集合处理
    public ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    // 使用栈解决
    public ListNode findFirstCommonNodeByStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode preNode = null;
        while (stackB.size() > 0 && stackA.size() > 0) {
            if(stackA.peek() == stackB.peek()) {
                preNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return preNode;
    }

    // 拼接字符串
    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            // 加下面这一行是为了防止2个链表没有共同节点会死循环
            if (p1 != p2) {
                // 当一个链表访问完了，就跳到另一个链表继续访问
                if(p1 == null) {
                    p1 = headB;
                }
                if(p2 == null) {
                    p2 = headA;
                }
            }
        }
        return p1;
    }

    // 解法四：差和双指针
    public ListNode findFirstCommonNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode current1 = headA;
        ListNode current2 = headB;
        int l1 = 0, l2 = 0;
        // 分别统计两个链表的长度
        while (current1 != null) {
            current1 = current1.next;
            l1++;
        }

        while (current2 != null) {
            current2 = current2.next;
            l2++;
        }
        current1 = headA;
        current2 = headB;
        int sub = l1 > l2 ? l1 - l2 : l2 - l1;
        // 长的先走sub步
        if(l1 > l2) {
            int a = 0;
            while (a < sub) {
                current1 = current1.next;
                a++;
            }
        }

        if(l1 < l2) {
            int a = 0;
            while (a < sub) {
                current2 = current2.next;
                a++;
            }
        }

        // 同时遍历2个链表
        while (current2 != current1) {
            current2 = current2.next;
            current1 = current1.next;
        }

        return current1;
    }
}
