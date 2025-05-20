package algorithm.二分查找;

/**
 *
 * [154. 寻找旋转排序数组中的最小值 II](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/)
 *
 */
public class findMin2 {

    // 循环
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    // 二分查找
    /**
     *  i,j双指针分别指向nums数组左右两端
     *
     *  情况：
     *
     *  a. nums[m] > nums[j]时，x一定在[m+1, j]闭区间内，执行i=m+1
     *  b. nums[m] < nums[j]时，x一定在[i, m]闭区间内，执行j=m
     *  c. nums[m] = nums[j]时，无法判断x在哪个区间，执行j=j-1缩小判断范围
     *
     *  返回：当i=j时跳出二分循环，返回nums[i]
     *
     *
     *
     *
     */
    public int findMin2(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<j) {
            int m = i + ((j-i)>>1);
            if (nums[m]>nums[j]) i=m+1;
            else if (nums[m]<nums[j]) j=m;
            else j--;  // 这里为什么要j--
        }
        return nums[i];
    }

}
