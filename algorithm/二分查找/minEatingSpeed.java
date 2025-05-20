package algorithm.二分查找;

import java.util.Arrays;

/**
 *
 * [875. 爱吃香蕉的珂珂](https://leetcode.cn/problems/koko-eating-bananas/description/)
 *
 */
public class minEatingSpeed {

    // 解题思路：
    // 如果h等于piles的长度，返回piles中最大
    // 我一开始是没想到二分查找的，为什么想到二分查找呢？
    //
    // 以 piles=[3,6,7,11] h=8为例
    // 如果珂珂能用k=4的速度吃掉所有香蕉，那么也能用更快的速度k=5，6，7....吃掉所有香蕉
    // 如果珂珂不能用k=3的速度吃掉所有香蕉，那么也不能用更慢的速度k=2,3....吃掉所有香蕉
    // 这个单调性意味着可以用二分查找猜出答案
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }
        while (left + 1 < right) {  // 开区间不为空
            int mid = left + (right - left) / 2;
            if (check(mid, piles, h)) {
                right = mid;  // 如果说mid这个值可以吃完，那么需要缩小下看看
            } else {
                left = mid;  // 如果说mid这个值吃不完，就需要增大下看看
            }
        }
        return right;  // 最小的 true 为什么是right？不是left？因为right的值是可以吃完的值，left的值是吃不完的值
    }

    // 检查mid这个值，能不能吃掉所有香蕉
    // 检查小时数是不是大于h
    private boolean check(int mid, int[] piles, int h) {
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / mid;  // 这里为什么-1呢？Java整数相除，向上取整的技巧
            if (sum > h) {
                return false;
            }
        }
        return true;
    }

    private boolean check2(int mid, int[] piles, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + mid - 1) / mid;  // 向上取整 这样更好理解一些，其实等价于上面的代码
            if (sum > h) return false;
        }
        return true;
    }
}
