package dataStructure.链表;

/**
 * 双向链表节点
 */
public class DoubleNode {
    public int data;
    public DoubleNode next;
    public DoubleNode prev;
    public DoubleNode(int data) {
        this.data = data;
    }
    // 打印节点的数据域
    public void displayNode() {
        System.out.println("{" + data + "}");
    }
}
