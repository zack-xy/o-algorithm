package algorithm.数组常见题.元素次数;

import java.util.HashMap;
import java.util.Map;

public class findSpecialInteger {
    /**
     *
     * [1287. 有序数组中出现次数超过25%的元素](https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/)
     *
     *
     *
     *
     *  剑指offer33题
     *
     *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     *  例如：输入如下所示的一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2，如果不存在则输出0。
     *
     *
     *  【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】
     *
     *  这两个题有相似性，但是不一样，Leetcode是有序数组，offer33是无序数组
     *
     */

    // Leetcode 1287

    // 解法一：计数 （如果变为无序数组的话，计数就失效了，没办法连续计数了）
    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int cur = arr[0], cnt = 0;
        for (int i=0;i<n;++i) {
            if (arr[i] == cur) {
                ++cnt;
                if (cnt * 4 > n) {
                    return cur;
                }
            } else {
                cur = arr[i];
                cnt = 1;
            }
        }
        return -1;
    }


    // 解法二：二分查找
    // 如果x在数组arr中出现了span=arr.length/4+1次
    // 那么可以断定：数组arr中的元素arr[0]、arr[span]、arr[span*2],...一定包含x
    // 然后二分查找arr[0]的位置和arr[0]+1的位置，如果区间大于span，就是要找的数字
    public static int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        for (int i=0;i<n;i+=span) {
            int start = binarySearch(arr, arr[i]);
            int end = binarySearch(arr, arr[i] + 1);
            if (end - start >= span) {
                return arr[i];
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }

    // 既然arr[0]、arr[span]、arr[span*2],...一定包含x
    // 为什么不能找这里面相同的一个？只要2个相同，就是要找的那个了
    // 因为前面的要求是2个相同，如果只有1个呢，如果有2个但是不相同呢？特殊情况不好处理
    public int findSpecialInteger5(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        int pre = arr[0];
        for (int i=span;i<n;i+=span) {
            if (arr[i] == pre) return arr[i];
            else pre = arr[i];
        }
        return -1;
    }

    // 使用map计数
    public int findSpecialInteger3(int[] arr) {
        if (arr == null) return 0;
        Map<Integer, Integer> res = new HashMap<>();
        int len = arr.length;
        for (int i=0;i<arr.length;i++) {
            res.put(arr[i], res.getOrDefault(arr[i], 0) + 1);
            if (res.get(arr[i])>len/4) return arr[i];
        }
        return 0;
    }


    /// ////////////////////////////////////////////////

    // 剑指offer 33
    public int moreThanHalfNum(int[] array) {
        if (array == null) return 0;
        Map<Integer, Integer> res = new HashMap<>();
        int len = array.length;
        for (int i=0;i<array.length;i++) {
            res.put(array[i], res.getOrDefault(array[i], 0) + 1);
            if (res.get(array[i])>len/2) return array[i];
        }
        return 0;
    }

    // 解法二：摩尔投票
    // 这种解法，找到的可能是超过一半的元素，还要进行验证
    // 原理是，如果有一个数字次数超过一半，那么它比其他所有数字加起来的次数还要多
    public static int moreThanHalfNum2(int[] array) {
        int count = 0;
        Integer candidate = null;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // 如果保证了数组中一定有超过一半的元素，就不需要验证了
        // return candidate == null ? 0 : candidate;

        // 验证候选元素是否真的出现次数超过数组长度的一半
        if (candidate != null) {
            count = 0;
            for (int num : array) {
                if (num == candidate) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return candidate;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
//        int[] arr1 = {1,2,1,3,1,4};
//        int[] arr2 = {1,2,1,3,1,4,1};
//        int[] arr3 = {1,1,1,2,2,2,3};
//        int[] arr4 = {1,2,2,6,6,6,6,7,10};
//        int res1 = moreThanHalfNum2(arr1);
//        int res2 = moreThanHalfNum2(arr2);
//        int res3 = moreThanHalfNum2(arr3);
//        System.out.println("res1 is :" + res1);
//        System.out.println("res2 is :" + res2);
//        System.out.println("res3 is :" + res3);
//
//        System.out.println(findSpecialInteger(arr1));

        int[] arr ={1,3,6,6,6,6,7,10};
        System.out.println(findSpecialInteger2(arr));

    }
}
