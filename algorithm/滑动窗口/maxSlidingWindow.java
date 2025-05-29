package algorithm.滑动窗口;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)
 *
 */
public class maxSlidingWindow {

    // 解法一：滑动窗口+堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // int[]是一个二元数组(num, index)表示num在数组中的index
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i=0;i<k;++i) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n-k+1];
        ans[0] = maxHeap.peek()[0];
        for (int i=k;i<n;++i) {
            maxHeap.offer(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            ans[i-k+1] = maxHeap.peek()[0];
        }
        return ans;
    }

    // TODO 单调队列

}
