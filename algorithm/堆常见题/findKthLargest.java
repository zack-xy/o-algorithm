package algorithm.堆常见题;

import java.util.PriorityQueue;

/**
 *
 * [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/description/)
 *
 */
public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        int len = nums.length;
        // 使用一个含有k个元素的小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i=0;i<k;i++) {
            minHeap.add(nums[i]);
        }
        for (int i=k;i<len;i++) {
            Integer topEle = minHeap.peek();
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
