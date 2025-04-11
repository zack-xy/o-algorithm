package algorithm.链表常见题.两链表第一个公共子节点;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

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
}


