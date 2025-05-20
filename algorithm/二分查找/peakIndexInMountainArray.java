package algorithm.二分查找;

/**
 *
 * [852. 山脉数组的峰顶索引](https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/)
 *
 *  必须O(log(n))的解决方案
 *
 */
public class peakIndexInMountainArray {

    // 遍历O(n)
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                return i - 1;
            }
        }
        return -1;
    }

    // 别人代码
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i=1;i<n-1;++i) {
            if (arr[i] > arr[i+1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    // 二分查找优化
    // 对于二分的某一个位置mid，mid可能的位置有3种情况
    // 1. mid在上升阶段，满足arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]
    // 2. mid在顶峰的时候，满足arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]
    // 3. mid在下降阶段，满足arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]
    public int peakIndexInMountainArray3(int[] arr) {
        if (arr.length == 3) return 1;
        int left = 1, right = arr.length - 2;
        while (left < right) {  // 这里为什么不是 left<=right 呢 ？因为这里不是找一个固定的值，这里是要找一个比left值大，比right值也大的
            int mid = left + ((right - left)>>1);
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            if (arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1]) left = mid+1;
            if (arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]) right = mid-1;
        }
        return left;
    }
}
