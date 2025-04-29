package algorithm.数组常见题.双指针;

public class removeDuplicates {
    /**
     *
     * [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/)
     *
     */

    // 解法一：快慢指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    // 换一种写法
    public int removeDuplicates2(int[] nums) {
        int slow = 1;
        for (int fast=0;fast<nums.length;fast++) {
            if(nums[fast]!=nums[slow-1]) {
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
