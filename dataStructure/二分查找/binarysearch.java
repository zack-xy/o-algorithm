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

}
