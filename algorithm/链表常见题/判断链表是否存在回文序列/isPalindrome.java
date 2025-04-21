package algorithm.链表常见题.判断链表是否存在回文序列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import dataStructure.链表.ListNode;

/**
 * 
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 * 
 */

public class isPalindrome {


    // 解法一：使用栈
    // 先访问一遍链表，挨个入栈，然后弹栈，挨个对比链表节点，只要有不相等的，就不是回文链表
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

    // 解法二：将值赋值到数组，使用双指针法
    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否是回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if(!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    // 解法三：递归
    private ListNode frontPointer;
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    // 解法三 - 递归函数
    // 这个递归函数会不停的往执行栈中增加栈帧，直到节点为null，也就是会把链表挨个压到执行栈里
    // 程序真正执行的时候，从栈顶执行，相当于就达到了从后向前遍历链表的效果
    // frontPointer从前到后
    // 递归的终止条件是：遍历到结尾
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    // 解法四：快慢指针
    /** 快指针每次走2步，慢指针每次走1步，快指针走到结尾的时候，慢指针正好在中间
     * 
     *  慢指针到中间后，反转后一半链表，然后判断是否回文
     * 
     *  最后恢复链表
     * 
     */
    public boolean isPalindrome4(ListNode head) {
        if (head == null) return true;

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否是回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;

    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    


}
