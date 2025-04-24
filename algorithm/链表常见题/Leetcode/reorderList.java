package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

import java.util.List;

/**
 * [143. 重排链表](https://leetcode.cn/problems/reorder-list/description/?envType=problem-list-v2&envId=linked-list)
 *
 *
 */
public class reorderList {

    // 我的第一版算法，想法是利用2个指针，依次处理，超出时间限制了，问题出在哪里？
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode cur = head;
        ListNode last = head;
        while (cur != null && cur.next != null) {
            while (last.next != null) {
                last = last.next;
            }
            ListNode temp = cur.next;
            cur.next = last;
            // 这一版出现的问题在这里，last指针在修改的时候，因为是单链表，修改了最后一个节点的next指向为temp节点
            // 导致形成了环形链表，那么前面的循环条件就永远不会结束了
            // 就变成了死循环，所以超出时间限制
            last.next = temp;
            cur = cur.next.next;
            last = cur;
        }
    }

    // 属于暴力解法，上面代码的问题解决版（逻辑比较绕）
    public static void reorderList2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode cur = head;
        ListNode last = head;
        while (cur.next != null && cur.next.next != null) {
            while (last.next != null && last.next.next != null) { // 因为要置null，所以相当于要找到最后1个节点的上一个节点
                last = last.next;
            }
            ListNode temp = cur.next;
            cur.next = last.next;
            last.next.next = temp;
            last.next = null;  // 设置为null，防止环形链表死循环
            if (cur.next != null) {
                cur = cur.next.next;
            }
            last = cur;
        }
    }

    // 解法二：寻找链表中点，反转右端链表，将反转后的链表与左端合并
    // 这里的关键是，反转后的链表，怎么和左半部分合并起来
    // 通俗来讲，这个合并是把右半部分的链表一个一个节点塞到左面的间隙里
    // 所以需要4个指针：
    // 1: 左面链表要插入的位置head
    // 2: 左边链表下一个要插入的位置（因为插入节点之后，位置变化了）nxt
    // 3: 右边要插入的节点head2
    // 4: 右边下一个要插入的节点（因为节点插入到左面之后，就不在左边了，无法通过next获取到下一个节点了）nxt2
    public void reorderList3(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        while (head2.next != null) {
            ListNode nxt = head.next;
            ListNode nxt2 = head2.next;
            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = nxt2;
        }
    }

    // 876. 链表的中间节点 (如果偶数个节点。找到的是中间第2个节点)
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 206. 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     *
     * 测试代码
     *
     */
    public static void main(String[] args) {
        // [1,2,3,4]
        ListNode linkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(linkedList);
    }
}
