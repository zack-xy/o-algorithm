package algorithm.二分查找;

/**
 *
 * 剑指offer：一个长度为n-1的递增排序数组种所有数字都是唯一的，并且每个数字都在范围0~n-1之内。在范围0～n-1内的n个数字中
 * 有且只有1个数字不在该数组中，请找出这个数字。
 *
 */

// 解题思路：二分查找出第一个 nums[i] != i
public class missingNumber {

    public int missingNumber(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid]==mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
