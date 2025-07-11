package dataStructure.堆;

import dataStructure.Util.PrintUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// Java中使用堆
public class useHeap {

    // 测试元素入堆
    public static void testPush(Queue<Integer> heap, int val) {
        heap.offer(val);  // 元素入堆
        System.out.format("\n元素 %d 入堆后\n", val);
        PrintUtil.printHeap(heap);
    }

    // 测试元素出堆
    public static void testPop(Queue<Integer> heap) {
        int val = heap.poll(); // 堆顶元素出堆
        System.out.format("\n堆顶元素 %d 出堆后\n", val);
        PrintUtil.printHeap(heap);
    }

    public static void main(String[] args) {
        // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        // 初始化大顶堆
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        System.out.println("\n以下测试样例为大顶堆");

        // 元素入堆
        testPush(maxHeap, 1);
        testPush(maxHeap, 3);
        testPush(maxHeap, 2);
        testPush(maxHeap, 5);
        testPush(maxHeap, 4);

        // 获取堆顶元素
        int peek = maxHeap.peek();
        System.out.format("\n堆顶元素为 %d\n", peek);

        // 堆顶元素出堆
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);

        // 获取堆大小
        int size = maxHeap.size();
        System.out.format("\n堆元素数量为 %d\n", size);

        // 判断堆是否为空
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\n堆是否为空 %b\n", isEmpty);

        // 输入列表并建堆
        minHeap = new PriorityQueue<>(Arrays.asList(1,3,2,5,4));
        System.out.println("\n输入列表并建立小顶堆后");
        PrintUtil.printHeap(minHeap);
    }
}
