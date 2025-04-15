[876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/description/)


[Java代码](./middleNode.java)
[TypeScript代码](./middleNode.ts)

##### 解法一： 

快慢指针，慢指针一次跳1步，快指针一次跳2步，
快指针到头，慢指针就在中间（如果有2个中间，慢指针在第2个中间）


------------------------------------------

[返回倒数第 k 个节点](https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/)

[Java代码](./kthToLast.java)
[TypeScript代码](./kthToLast.ts)


##### 快慢指针的解法：

fast指针遍历到k+1个节点，slow指向第一个节点，此时二者间隔k个节点，之后同步向后走，当fast走到最后的时候，slow的位置就是倒数第K个节点


--------------------------------------------

[61. 旋转链表](https://leetcode.cn/problems/rotate-list/description/)

[Java代码](./rotateRight.java)
