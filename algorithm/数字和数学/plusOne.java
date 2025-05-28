package algorithm.数字和数学;

/**
 *
 * [66. 加一](https://leetcode.cn/problems/plus-one/description/)
 *
 */
public class plusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            // 如果digits[i] == 0说明发生进位
            // 循环继续处理前一位数，如果前一位没有进位，则digits[i]!=0，就会返回
            digits[i]++;
            digits[i] %= 10; // 如果没有发生进位，则digits[i]!=0
            if (digits[i] != 0) return digits;  // 没有发生进位，直接返回加1后的数组
        }
        // 如果代码运行到这里，说明所有位都是0，所有位都进位了
        // 那么这个数组长度需要+1，并且数组第一位是1
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
