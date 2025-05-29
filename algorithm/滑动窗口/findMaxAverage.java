package algorithm.滑动窗口;

/**
 *
 * [643. 子数组最大平均数 I](https://leetcode.cn/problems/maximum-average-subarray-i/description/)
 *
 */
public class findMaxAverage {

    // 滑动窗口长度固定
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int windowSum = 0;
        if (k > nums.length || nums.length < 1 || k < 1) return 0;
        // 第一步 先求第一个窗口的和
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // 第二步：遍历，每次右边增加1个，左边减少1个，从新计算窗口最大值
        int res = windowSum;  // 这个变量用来存储最大的值
        for (int right = k; right < len; right++) {
            windowSum += nums[right] - nums[right - k];
            res = Math.max(res, windowSum);
        }
        return (double) res / k;
    }

}
