package dataStructure.二分查找;

public class binarysearch {

    // 二分查找递归写法
    // 这里也是无重复元素
    public int binarySearch(int[] array, int low, int high, int target) {
        // 递归终止条件
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == target) return mid;
            if (array[mid] > target) return binarySearch(array, low, mid-1, target);
            if (array[mid] < target) return binarySearch(array, mid+1, high, target);
        }
        return -1;
    }


    // 如果是有重复元素，如果查找的元素重复，则找左侧第1个
    // 这里的方法是线性向左查找
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 找到之后，往左找
                while (mid != 0 && nums[mid] == target) mid--;
                if (mid == 0 && nums[mid] == target) return mid;
                return mid + 1;
            }
        }
        return -1;
    }



}
