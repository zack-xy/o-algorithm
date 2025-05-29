package dataStructure.堆;

import dataStructure.Util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 大顶堆
public class MaxHeap {
    // 使用列表而非数组，无需考虑扩容问题
    private List<Integer> maxHeap;

    // 构造方法，根据输入列表建堆
    public MaxHeap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        maxHeap = new ArrayList<>(nums);
        // 堆化除叶节点之外的其他所有节点，【为什么要这样堆化呢？】
        //
        for (int i = parent(size() - 1); i>=0; i--) {
            siftDown(i);
        }
    }

    // 获取左子节点索引
    private int left(int i) {
        return 2 * i + 1;
    }

    // 获取右子节点索引
    private int right(int i) {
        return 2 * i + 2;
    }

    // 获取父节点索引
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // 交换元素
    private void swap(int i, int j) {
        int tmp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, tmp);
    }

    // 获取堆大小
    public int size() {
        return maxHeap.size();
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 访问堆顶元素
    public int peek() {
        return maxHeap.get(0);
    }

    // 元素入堆
    public void push(int val) {
        // 添加节点
        maxHeap.add(val);
        // 从底至顶堆化
        siftUp(size() - 1);
    }

    // 从节点i开始，【从底至顶堆化】
    private void siftUp(int i) {
        while (true) {
            // 获取节点i的父节点
            int p = parent(i);
            // 当【越过根节点】或【节点无需修复】时，结束堆化
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p)) break;
            // 否则需要堆化，交换节点
            swap(i, p);
            // 循环向上堆化
            i = p;
        }
    }

    // 元素出堆
    public int pop() {
        // 判空处理
        if (isEmpty()) throw new IndexOutOfBoundsException();
        // 交换根节点与最右叶节点（交换堆顶元素和堆尾元素）
        swap(0, size() - 1);
        // 删除节点
        int val = maxHeap.remove(size() - 1);
        // 从顶至底堆化
        siftDown(0);
        // 返回堆顶元素
        return val;
    }

    // 从节点i开始，【从顶至底堆化】
    private void siftDown(int i) {
        while (true) {
            // 判断节点i、l、r中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma)) ma = l;
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma)) ma = r;
            // 若节点i最大或索引l，r越界，则无需继续堆化，跳出
            if (ma == i) break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }

    // 打印堆（二叉树）
    public void print() {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {return b-a;});
        queue.addAll(maxHeap);
        PrintUtil.printHeap(queue);
    }

}
