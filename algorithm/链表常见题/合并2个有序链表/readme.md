
[21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/description/)


--------------------------------

##### 解法一：

虚拟头节点     
开启while循环，直到list1和list2有一个链表为空    
每次比较list1和list2的值，将较小的节点添加到当前链表中     
最后将非空的链表添加到当前链表中    
返回虚拟头节点的下一个节点     
复杂度: O(n)     

[Java代码](./mergeTwoLists.java)   
[TypeScript代码](./mergeTwoLists.ts)    






--------------------------------

[1669. 合并两个链表](https://leetcode.cn/problems/merge-in-between-linked-lists/description/)


[Java代码](./mergeInBetween.java)
[TypeScript代码](./mergeInBetween.ts)

##### 解法一：

1、需要找到链表list1的a节点的上一个节点（从这里断开链接链表list2
2、需要找到链表list1的b节点的下一个节点（从这里链接list2的尾部
所以需要3个变量，1个指向a节点的上一个节点，1个指向b节点的下一个节点，1个指向list2的尾部
变量1.next = list2的头节点
list2的尾部.next = 变量2
另外需要i，j两个变量，用来计数到a和b位置
