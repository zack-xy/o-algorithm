package algorithm.数组常见题.双指针;

public class removeDuplicates2 {
    /**
     *
     * [80. 删除有序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/)
     *
     */

    // 解法一：双指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow-2] != nums[fast]) {
                nums[slow]=nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}
