package algorithm.二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [29. 两数相除](https://leetcode.cn/problems/divide-two-integers/description/)
 * 不让使用乘法，除法
 */
public class divide {

    // 我使用减法可以么？-2147483648解答错误
    // 边界情况处理了，算法本身应该没有问题了，超出时间限制
    public static int divide(int dividend, int divisor) {
        boolean negative = false;
        boolean overflow = false;
        if ((dividend < 0  && divisor > 0) || (dividend > 0 && divisor < 0)) negative = true;
        if (dividend == -2147483648) {
            overflow = true;
            dividend = -2147483647;
        }
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        if (dividend < divisor) return 0;
        int ret = 1;
        while (dividend - divisor > divisor) {
            dividend = dividend - divisor;
            if (!negative && ret == 2147483647) {
                break;
            }
            ret++;

        }
        if (overflow) {
            dividend += 1;
            while (dividend - divisor >= divisor) {
                dividend = dividend - divisor;
                if (!negative && ret == 2147483647) {
                    break;
                }
                ret++;
            }
        }
        return negative ? -ret : ret;
    }

    // 二分查找
    // TODO 算术问题，没有完全看懂
    public int divide1(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为0的情况
        if (dividend == 0) return 0;

        // 一般情况,使用二分查找
        // 将所有的正数取相反数，这样只需要考虑一种情况
        boolean rev = false;  // 标志正负数,false表示正数
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left=1, right=Integer.MAX_VALUE, ans=0;
        while(left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left)>>1);
            boolean check = quickAdd(divisor, mid, dividend); // quickAdd成立说明有余裕，还能除
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {  // 不够除了
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // y是除数，x是被除数
    // z是1～最大正整数之间的一个数
    // 这个函数具体是判断什么的？判断z*y>=x是否成立
    private boolean quickAdd(int y, int z, int x) {
        // x和y是负数，z是正数
        // 需要判断z*y>=x是否成立，成立了表示 z个｜y｜ <= |x|，因为是负数嘛
        int result=0, add=y;
        while (z!=0) {
            if ((z&1)!=0) { // 判断z最低位是否为1，也就是z是否为奇数
                // 需要保证result+add>=x
                if(result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法 (相当于是z/2)
            z >>= 1;
        }
        return true;
    }


    // 类二分查找
    public int divide2(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为0的情况
        if (dividend == 0) return 0;

        // 一般情况，使用类二分查找
        // 将所有的正数取相反数，这样只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        List<Integer> candidates = new ArrayList<>();
        candidates.add(divisor);
        int index = 0;
        // 注意溢出
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i=candidates.size()-1;i>=0;--i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }

        return rev ? -ans : ans;
    }

    public static void main(String[] args) {

    }
}
