package algorithm.堆常见题;

import java.util.PriorityQueue;

/**
 *
 * [703. 数据流中的第 K 大元素](https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/)
 *
 */
public class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
       this.k = k;
       minHeap = new PriorityQueue<Integer>();
       for (int x : nums) {
           add(x);
       }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
