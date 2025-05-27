package algorithm.位运算;

/**
 *
 * [190. 颠倒二进制位](https://leetcode.cn/problems/reverse-bits/description/)
 *
 */
public class reverseBits {

    // 解法：访问到最低位放到相应位置，n右移动1位，相加，直到n为0
    // 对于n的二进制表示的从低到高第i位，在颠倒之后变成31-i位（0<=i<32）
    // 可以从低到高遍历n的二进制表示的每一位，将其放到其在颠倒之后的位置，最后相加即可
    public static int reverseBits(int n) {
        int reversed = 0, power = 31;
        while (n != 0) {
            // 这里n & 1也就是n的二进制与0000....001每位与运算
            // 结果是获取最后1位的二进制值，也就是n的二进制最后一位是1，1&1=1，是0，就是0
            // << 左移操作，将最后一位左移power位，结果就是1000000000000000000000...
            // reversed和这个结果相加，reversed就是1000000000000000000000...
            // 循环这个步骤，下一步，reversed就是和除了1的后半部份二进制相加
            reversed += (n & 1) << power;  // 运算符优先级 & --> << --> +=
            n >>>= 1;  // 有符号整数，算术右移
            power--;
        }
        return reversed;
    }

    // 解法二：分段反转
    // 这里题目给定的是无符号整数，所以选择无符号整数右移动，也叫逻辑右移
    public int reverseBits2(int n) {
        n = ( n >>> 16) | ( n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        int ret = reverseBits(100);
        System.out.println(ret);
    }
}
