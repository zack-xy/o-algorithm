package algorithm.二分查找;

/**
 *
 * [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/)
 *
 */
public class findMin {

    // 二分查找
    // 什么原理？

    /**
     *  根据旋转的规则，只有2种情况：
     *  1. 旋转n次之后，还是原数组，也就是排序互不相同的原数组
     *  2. 旋转n次之后，分为2截，2截都是递增的（最后1截只有1个数字，也是1截），而且最小的一定在后一截里
     *  而且前一截的数据均大于后一截
     *
     *
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < nums[high]) {
                high = mid;  // 这里为什么不是mid-1呢？如果此时mid已经是最小
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
