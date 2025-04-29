package algorithm.数组常见题.数组插入;

public class searchInsert {
    /**
     *
     * [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/description/)
     *
     */

    // 解法一：循环查找
    public int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    // 解法二：二分查找
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
