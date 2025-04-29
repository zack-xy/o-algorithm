package algorithm.数组常见题.数组合并;

public class merge {

    /**
     *
     * [88. 合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/description/)
     *
     */

    // 解法一：找到nums1和nums2中最大，从后向前填
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int len1 = m - 1, len2 = n - 1;
        while (len1 >= 0 && len2 >=0) {
            if (nums1[len1] <= nums2[len2]) nums1[i--] = nums2[len2--];
            else if (nums1[len1] > nums2[len2]) nums1[i--] = nums1[len1--];
         }
        // 假如数组还有剩余
        while (len2 != -1) nums1[i--] = nums2[len2--];
        while (len1 != -1) nums1[i--] = nums1[len1--];
    }

    // 解法二：双指针，额外开辟空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m+n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1+p2-1] = cur;
        }
        for (int i=0;i!=m+n;++i) {
            nums1[i] = sorted[i];
        }
    }
}
