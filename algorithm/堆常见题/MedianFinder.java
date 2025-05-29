package algorithm.堆常见题;

import java.util.PriorityQueue;

/**
 *
 * [295. 数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/description/)
 *
 */

// 一个大顶堆，一个小顶堆，把数据分成大小两半
// 中位数就是大顶堆中最小和小顶堆中最大
// 如果大顶堆真的是较大的，找最小比较难找，所以大顶堆存较小的元素，堆顶就是一堆小里最大的
public class MedianFinder {

    // 小顶堆中存储的是比较大的元素，堆顶是其中最小值
    PriorityQueue<Integer> minHeap;
    // 大顶堆中存储的是比较小的元素，堆顶是其中最大值
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 小顶堆存储的是比较大的元素
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
            // 如果minHeap比maxHeap多2个元素，就平衡一下
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());  // 从小顶堆拿出最小的放到大顶堆中
            }
        } else {
            maxHeap.offer(num);
            // 如果大顶堆元素多，就移到小顶堆中，保证多的元素在minHeap
            if (maxHeap.size() - minHeap.size() > 0) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

}
