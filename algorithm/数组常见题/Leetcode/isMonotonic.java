package algorithm.数组常见题.Leetcode;

public class isMonotonic {

    /**
     *
     * [896. 单调数列](https://leetcode.cn/problems/monotonic-array/)
     *
     */

    // 解法一：判断两次，只要有一次是true就可以了 (2次遍历)
    public boolean isMonotonic(int[] nums) {
        return isSorted(nums, true) || isSorted(nums, false);
    }

    public boolean isSorted(int[] nums, boolean increasing) {
        int n = nums.length;
        for (int i=0;i<n-1;++i) {
            if (increasing) {
                if (nums[i] > nums[i+1]) return false;
            } else {
                if (nums[i] < nums[i+1]) return false;
            }
        }
        return true;
    }

    // 解法二：可以通过2个变量标记一下 （1次遍历）
    public boolean isMonotonic2(int[] nums) {
        boolean inc = true, dec = true;
        int n = nums.length;
        for (int i=0;i<n-1;++i) {
            if (nums[i] > nums[i+1]) {
                inc = false;
            }
            if (nums[i]<nums[i+1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
