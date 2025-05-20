package algorithm.数组常见题.二分查找;

public class searchRange {
    /**
     *
     * [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/)
     * 排序数组，要求时间复杂度为O(log n)
     */

    // 解法一：循环，时间复杂度O(n)
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return new int[]{start, end};
    }

    // 解法二：二分
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx =  binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left=0,right=nums.length-1,ans=nums.length;
        while (left<=right) {
            int mid = (left+right)>>1;
            if (nums[mid]>target || (lower && nums[mid]>=target)) {
                right=mid-1;
                ans=mid;
            } else {
                left=mid+1;
            }
        }
        return ans;
    }


    public int[] searchRange3(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    // 左边位置
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }

    // 右边位置
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }
}
