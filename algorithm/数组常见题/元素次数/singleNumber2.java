package algorithm.数组常见题.元素次数;

import java.util.HashMap;
import java.util.Map;

public class singleNumber2 {
    /**
     *
     * [137. 只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/description/)
     * 要求线性时间复杂度，常数级空间
     */

    // 解法一：使用哈希表计数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }

    // 解法二：依次确定每一个二进制位
    // 这里32是32位整数的意思
    /**
     * 解释一下这个代码：
     *
     *  原理：因为3个数是相等的，所以这3个数的第i位相加是0或者1，对3取余一定是0
     *  如果不为0的话，那么这个位就是要找的那个数的位，所以把这一位设置为1
     *
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i=0;i<32;++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    // 解法三：数字电路设计
    // TODO 没看，可能不好理解，后续再来看
    // 这个是解法二的优化
    public int singleNumber3(int[] nums) {
        int a=0,b=0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

    // 解法四：数字电路设计优化
    // 也叫状态机
    // TODO 没看，可能不好理解，后续再来看
    public int singleNumber4(int[] nums) {
        int a=0,b=0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}
