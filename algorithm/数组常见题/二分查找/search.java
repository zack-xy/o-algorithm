package algorithm.数组常见题.二分查找;

public class search {
    /**
     *
     * [704. 二分查找](https://leetcode.cn/problems/binary-search/description/)
     *  最基础款的二分查找，有序数组，没有重复元素
     */

    // 二分查找写法一：区间是[left, right]
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right) {
            int mid=left+((right-left)>>1);
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) right=mid-1;
            if (nums[mid]<target) left=mid+1;
        }
        return -1;
    }

    // 二分查找写法二：区间是[left, right)
    public static int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length; // 不同点1: 不包含right，所以是nums.length
        while(left<right) {  // 不同点2
            int mid=left+((right-left)>>1);
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) right=mid; // 不同点3
            if(nums[mid]<target) left=mid+1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 2));
    }
}
