package algorithm.滑动窗口;

/**
 *
 * [674. 最长连续递增序列](https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/)
 *
 */
public class findLengthOfLCIS {

    // 滑动窗口
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            // 右侧的新元素比左侧小，则重新开始记录left位置
            if (right > 0 && nums[right-1] >= nums[right]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    // 遍历
    public int findLengthOfLCIS2(int[] nums) {
        int curLen = 1;  // 当前连续递增区间的长度
        int res = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i-1] >= nums[i]) {
                // 不满足要求，重新开始计数
                curLen = 1;
            } else {
                curLen++;
            }
            res = Math.max(curLen, res);
        }
        return res;
    }

}
