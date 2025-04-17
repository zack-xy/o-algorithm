package dataStructure.斐波那契堆;

public class FibHeap {

    private int keyNum;  // 堆中节点的总数
    private FibNode min;

    private class FibNode {
        public int key;   // 关键字（键值）
        public int degree; // 度数
        public FibNode left; // 左兄弟
        public FibNode right; // 右兄弟
        public FibNode child; // 第一个孩子节点
        public FibNode parent; // 父节点
        public boolean marked; // 是否被删除第一个孩子

        public FibNode(int key) {
            this.key = key;
            this.degree = 0;
            this.marked = false;
            this.left = this;
            this.right = this;
            this.parent = null;
            this.child = null;
        }
    }
}
