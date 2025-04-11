package algorithm.链表常见题.判断链表是否存在回文序列;

import java.util.Stack;
import dataStructure.链表.ListNode;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        // 把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while (head != null) {
            if(head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
