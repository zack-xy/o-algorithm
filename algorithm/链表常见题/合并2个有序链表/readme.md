
[21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/description/)


--------------------------------

##### 解法一：

虚拟头节点     
开启while循环，直到list1和list2有一个链表为空    
每次比较list1和list2的值，将较小的节点添加到当前链表中     
最后将非空的链表添加到当前链表中    
返回虚拟头节点的下一个节点     
复杂度: O(n)     
