package algorithm.数组常见题.元素次数;

import java.util.*;

public class singleNumber {

    /**
     *
     * [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/description/)
     *
     *  要求是常量空间和线性时间
     *
     */

    // 解法一： 使用Set （这个空间不是常量的）
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
           if (set.contains(num)) {
               set.remove(num);
           } else {
               set.add(num);
           }
        }
        return set.iterator().next();
    }

    // 解法二： 利用异或性质，使用异或运算
    public int singleNumber2(int[] nums) {
        int flag = 0;
        for (int num : nums) {
            flag ^= num;
        }
        return flag;
    }


}
