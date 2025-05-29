package algorithm.滑动窗口;

/**
 *
 * [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/description/)
 *
 */
public class minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
