package algorithm.二分查找;

/**
 *
 * [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/description/)
 *  要求是log(m+n)
 */
public class findMedianSortedArrays {

    // 解法1:合并2个数组，O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] <= nums2[idx2]) nums[idx++] = nums1[idx1++];
            else nums[idx++] = nums2[idx2++];
        }
        while (idx1 < nums1.length) {
            nums[idx++] = nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            nums[idx++] = nums2[idx2++];
        }
        if (nums.length % 2 == 0) {
            int mid = nums.length / 2;
            return (double) (nums[mid - 1] + nums[mid]) / 2;
        }
        return nums[nums.length / 2];
    }

    // 解法2: 双指针
    // 两个指针的下标和等于中间
    // 每次把两个数中较小的指针向后移动1位
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;  // left表示的是len/2-1的位置值，right表示的是len/2位置的值
        int start1 = 0, start2 = 0;  // start1是数组1的指针、start2是数组2的指针
        // 如果len是奇数，找的是len/2的位置
        // 如果len是偶数，找的是len/2-1和len/2的位置
        for (int i=0;i<=len/2;i++) {
            left = right;
            // 情况1: 指针1在索引范围内并且索引2不在索引范围内
            // 情况2: 指针1在索引范围内指针2也在索引范围内，索引1的值小于索引2的值
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0) return (left + right) / 2.0;
        else return right;
    }

    // 解法3: 二分法
    // 题目转化为在2个数组中找第k小的数字
    // 因为数组有序，在找第k小的数字的时候，可以k/2的排除
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            // 如果m+n是奇数，中位数就是2个有序数组中第(m+n)/2+1个数
            // 比如总数9，中位数就是第5个数
            double median = getKthElement(nums1, nums2, totalLength / 2 + 1);
            return median;
        } else {
            // 如果m+n是偶数，中位数就是第/2个数和第/2+1个数的和除2
            // 比如8，中位数就是第4个数和第5个数
            double median = (getKthElement(nums1, nums2, totalLength / 2) + getKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
            return median;
        }
    }

    // 在两个有序数组中找到第k小的元素
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            // 这个二分是什么意思呢？
            // 假设2个有序数组分别是LA和LB，可以比较LA[k/2-1]和LB[k/2-1]
            // 由于LA[k/2-1]和LB[k/2-1]前面分别有LA[0~k/2-2]个元素和LB[0~k/2-2]个元素，一共是k/2-1个元素
            int half = k / 2;  //
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    // 解法4:二分法+递归
    // 这里本质也是在找第k小的数
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n+m+1)/2;  // 如果m+n是偶数，比如8，left就是4，如果是奇数，比如9，left就是5
        int right = (n+m+2)/2; // 如果m+n是偶数，比如8，left就是5，如果是奇数，比如9，left就是5
        // 将偶数和奇数情况合并，如果是奇数，求两次同样的k
        return (getKth(nums1, 0, n-1, nums2, 0, m-1, left) + getKth(nums1, 0, n-1, nums2, 0, m-1, right)) * 0.5;
    }

    // 查找第k小的数
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让len1的长度小于len2，这样就能保证如果有数组空了，一定是len1
        // 总是保证第一个传入的数组是比较短的那一个，也就是len1总是最短的
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        // 因为len1总是最短的，所以一定是先为0的
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j+1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i+1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    // 解法5:
    // TODO 不好理解，一时也看不懂，后续再研究
    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays5(nums2, nums1);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m+n+1) / 2 - i;
            if (j != 0 && i != m && nums2[j-1] > nums1[i]) {
                // i需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && nums1[i-1] > nums2[j]) {
                // i需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ( (m+n) % 2 == 1 ) { // 奇数不需要考虑右半部分
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;

            }
        }
        return 0.0;
    }

}
