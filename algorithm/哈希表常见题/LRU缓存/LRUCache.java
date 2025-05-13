package algorithm.哈希表常见题.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/description/)
 *
 * 缓存的基本方式：FIFO，LRU，LFU
 * FIFO：队列方式，不能很好利用程序局部性特征，缓存效果比较差
 * LRU：淘汰最长时间没有被使用的页面
 * LFU：淘汰一段时间内，使用次数最少的页面
 *
 */

// 实现方式是Hash+双向链表
// Hash的作用是用来O(1)访问元素，key是：查询条件 value是：链表的节点的引用
// 双向链表对元素访问情况进行排序，靠近头部是最近使用的，靠近尾部的是最久未使用的
// 为了方便，双向链表中使用伪头部和伪尾部
public class LRUCache {

    // 双向链表节点类
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    // 以正整数作为容量初始化LRU缓存
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // 如果关键字key存在与缓存中，则返回关键字的值，否则返回-1
    /**
     * 操作：
     * 首先判断key是否存在：
     *      + 如果key不存在，则返回-1
     *      + 如果key存在，把这个节点从双向链表中移动到头部，并返回该节点的值
     *
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        // 如果key存在，先通过哈希表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }

    // 如果关键字key已经存在，则变更其数据值value
    // 如果不存在，则向缓存中插入该组key-value
    // 如果插入操作导致关键字数量超过capacity，则应该逐出最久未使用的关键字

    /**
     * 操作：
     * 首先判断key是否存在：
     *      + 如果key不存在，创建新节点，在双向链表头部添加这个节点，在哈希表中加入这个节点，还要判断
     *      是不是超出容量了，超出容量要删除双向链表的尾部节点，并且要在哈希表中删除这个项
     *      + 如果key存在，通过哈希表定位到这个节点，value更新一下，把这个节点移动到双向链表的头部
     */

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // key不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加到哈希表
            cache.put(key, newNode);
            // 添加到双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // 将节点添加到头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 移除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移动节点到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除最后一个节点(不是虚拟尾节点）
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
